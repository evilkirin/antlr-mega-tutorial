package me.tomassetti.examples.sandy.ast;

import lombok.Data;

@Data
public final class TypeConversion implements Expression {

    private final Expression value;

    private final Type targetType;

    private final Position position;
}
