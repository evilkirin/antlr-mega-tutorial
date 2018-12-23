package me.tomassetti.examples.sandy.ast;

import lombok.Data;

@Data
public final class Position {

    private final Point start;
    private final Point end;

    public Position(Point start, Point end) {
        super();
        this.start = start;
        this.end = end;
    }
}
