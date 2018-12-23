package me.tomassetti.examples.sandy.ast;

import lombok.Data;


@Data
public final class VarReference implements Expression {

    private final String varName;

    private final Position position;
}
