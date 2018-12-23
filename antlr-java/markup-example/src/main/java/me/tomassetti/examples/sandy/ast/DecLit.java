package me.tomassetti.examples.sandy.ast;

import lombok.Data;

@Data
public final class DecLit implements Expression {

    private final String value;

    private final Position position;
}
