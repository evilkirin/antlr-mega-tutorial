package me.tomassetti.examples.sandy.ast;

import lombok.Data;

import java.util.List;

@Data
public final class SandyFile implements Node {

    private final List<Statement> statements;

    private final Position position;
}
