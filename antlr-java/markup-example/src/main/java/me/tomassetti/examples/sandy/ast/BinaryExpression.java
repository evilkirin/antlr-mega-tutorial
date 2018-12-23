package me.tomassetti.examples.sandy.ast;

public interface BinaryExpression extends Expression {

    Expression getLeft();

    Expression getRight();
}
