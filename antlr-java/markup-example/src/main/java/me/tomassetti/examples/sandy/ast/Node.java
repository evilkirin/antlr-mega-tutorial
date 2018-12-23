package me.tomassetti.examples.sandy.ast;

import com.google.common.reflect.TypeParameter;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


public interface Node {

    Position getPosition();

    Class<?> CLAZZ = new TypeParameter<Collection<?>>() {}.getClass();

    default boolean isBefore(Node another) {
        if (another == null)
            return false;

        return getPosition().getStart().isBefore(another.getPosition().getStart());
    }

    default void process(Consumer<Node> consumer) throws IllegalAccessException {
        consumer.accept(this);

        Field[] fields = this.getClass().getFields();
        for (Field field : fields) {
            Object v = field.get(this);

            if (v instanceof Node) {
                consumer.accept((Node) v);
            } else if (CLAZZ.isInstance(v)) {
                ((Collection) v).forEach(n -> {
                    if (Node.class.isInstance(n))
                        consumer.accept((Node) n);
                });
            }
        }
    }

    default <T extends Node> void specificProcess(Class<T> klass, Consumer<Node> consumer) throws IllegalAccessException {
        process(n -> {
            if (klass.isInstance(n)) {
                consumer.accept(n);
            }
        });
    }

    @SuppressWarnings("unchecked")
    default Node transform(Function<Node, Node> function) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        function.apply(this);
        Map<String, Object> changes = new HashMap<>();

        Field[] fields = this.getClass().getFields();
        for (Field field : fields) {
            Object v = field.get(this);

            if (v instanceof Node) {
                Node newValue = function.apply((Node) v);
                if (!newValue.equals(v))
                    changes.put(field.getName(), newValue);
            } else if (CLAZZ.isInstance(v)) {
                Object newValue = ((Collection) v).stream().map(n -> {
                    if (Node.class.isInstance(n)) {
                        try {
                            return ((Node) n).transform(function);
                        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                    return n;
                }).collect(Collectors.toList());

                if (newValue != v)
                    changes.put(field.getName(), newValue);
            }
        }

        Node node2Transform = this;
        if (!changes.isEmpty()) {
            Class<? extends Node> aClass = this.getClass();
            Node node = aClass.newInstance();
            BeanUtils.copyProperties(node, this);
            BeanUtils.copyProperties(node, changes);
            node2Transform = node;
        }

        return function.apply(node2Transform);
    }
}


