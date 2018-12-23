package me.tomassetti.examples.sandy.ast;

import lombok.Data;

@Data
public final class IntType implements Type {

    private final Position position;

    public Position getPosition() {
        return this.position;
    }

    public IntType(Position position) {
        this.position = position;
    }

    public IntType() {
        this(null);
    }

}
