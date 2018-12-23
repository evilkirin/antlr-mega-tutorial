package me.tomassetti.examples.sandy.ast;

import lombok.Data;


@Data
public final class MultiplicationExpression implements BinaryExpression {

    private final Expression left;

    private final Expression right;

    private final Position position;


    public MultiplicationExpression(Expression left, Expression right, Position position) {
        super();
        this.left = left;
        this.right = right;
        this.position = position;
    }
}
