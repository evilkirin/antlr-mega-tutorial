package me.tomassetti.examples.sandy.ast;

import lombok.Data;

@Data
public final class Print implements Statement {

    private final Expression value;

    private final Position position;
}
