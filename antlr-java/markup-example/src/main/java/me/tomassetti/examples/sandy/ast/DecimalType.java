package me.tomassetti.examples.sandy.ast;

import lombok.Data;

@Data
public final class DecimalType implements Type {

    private final Position position;

    public Position getPosition() {
        return this.position;
    }

    public DecimalType(Position position) {
        this.position = position;
    }

    public DecimalType() {
        this(null);
    }

}
