package me.tomassetti.examples.sandy.ast;

import lombok.Data;

@Data
public final class UnaryMinusExpression implements Expression {

    private final Expression value;

    private final Position position;
}
