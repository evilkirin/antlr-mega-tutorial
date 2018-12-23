package me.tomassetti.examples.sandy.ast;


import lombok.Data;

@Data
public final class SumExpression implements BinaryExpression {

    private final Expression left;

    private final Expression right;

    private final Position position;
}
