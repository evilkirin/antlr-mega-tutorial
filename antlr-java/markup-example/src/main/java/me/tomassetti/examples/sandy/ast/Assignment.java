package me.tomassetti.examples.sandy.ast;

import java.util.Objects;

public final class Assignment implements Statement {

    private final String varName;
    private final Expression value;
    private final Position position;

    public final String getVarName() {
        return this.varName;
    }


    public final Expression getValue() {
        return this.value;
    }


    public Position getPosition() {
        return this.position;
    }

    public Assignment(String varName, Expression value, Position position) {
        super();
        this.varName = varName;
        this.value = value;
        this.position = position;
    }

    public final String component1() {
        return this.varName;
    }


    public final Expression component2() {
        return this.value;
    }


    public final Position component3() {
        return this.getPosition();
    }


    public final Assignment copy(String varName, Expression value, Position position) {
        return new Assignment(varName, value, position);
    }

    public String toString() {
        return "Assignment(varName=" + this.varName + ", value=" + this.value + ", position=" + this.getPosition() + ")";
    }

    public int hashCode() {
        int var10000 = ((this.varName != null ? this.varName.hashCode() : 0) * 31 + (this.value != null ? this.value.hashCode() : 0)) * 31;
        Position var10001 = this.getPosition();
        return var10000 + (var10001 != null ? var10001.hashCode() : 0);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (var1 instanceof Assignment) {
                Assignment var2 = (Assignment) var1;
                if (Objects.equals(this.varName, var2.varName) && Objects.equals(this.value, var2.value) && Objects.equals(this.getPosition(), var2.getPosition())) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }
}
