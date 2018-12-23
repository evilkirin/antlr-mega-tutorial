package me.tomassetti.examples.sandy.ast;

import lombok.Data;

@Data
public final class IntLit implements Expression {

    private final String value;

    private final Position position;
}
