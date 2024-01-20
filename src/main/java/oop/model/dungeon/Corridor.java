package oop.model.dungeon;

import java.util.Objects;

public class Corridor {
    private final int beg;
    private final int end;
    public Corridor(int beg, int end){
        this.beg=beg;
        this.end=end;
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Corridor))
            return false;
        Corridor that = (Corridor) other;
        if (this.beg == that.beg & this.end == that.end) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(beg, end);
    }

    public int getBeg() {
        return beg;
    }

    public int getEnd() {
        return end;
    }

    public String toString(){
        return beg+" "+end;
    }
}
