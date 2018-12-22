package Advent_of_code_2018.days.day22;

import java.util.Objects;

public class Pos3D {
    final int x;
    final int y;
    final int depth;

    public Pos3D(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    public Pos3D(String s, int depth) {
        x = Integer.parseInt(s.split(",")[0]);
        y = Integer.parseInt(s.split(",")[1]);
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pos3D pos3D = (Pos3D) o;
        return x == pos3D.x &&
                y == pos3D.y &&
                depth == pos3D.depth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, depth);
    }
}
