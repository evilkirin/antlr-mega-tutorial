package me.tomassetti.examples.sandy.ast;

import lombok.Data;

import java.util.Objects;

@Data
public final class VarDeclaration implements Statement {

    private final String varName;

    private final Expression value;

    private final Position position;
}
