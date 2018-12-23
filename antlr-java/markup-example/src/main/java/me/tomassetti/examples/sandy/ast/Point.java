package me.tomassetti.examples.sandy.ast;

import lombok.Data;

@Data
public final class Point {
    private final int line;
    private final int column;

    public boolean isBefore(Point another) {
        return line < another.line || (line == another.line && column < another.column);
    }

    public Point(int line, int column) {
        this.line = line;
        this.column = column;
    }
}
