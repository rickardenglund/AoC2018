package Advent_of_code_2018.days.day25;

public class Pos {
    private final int x;
    private final int y;
    private final int z;
    private final int w;

    public Pos(String it) {
        String[] coords = it.split(",");
        x = Integer.parseInt(coords[0].trim());
        y = Integer.parseInt(coords[1].trim());
        z = Integer.parseInt(coords[2].trim());
        w = Integer.parseInt(coords[3].trim());
    }

    @Override
    public String toString() {
        return "Pos{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", w=" + w +
                '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getW() {
        return w;
    }

    public int distance(Pos other) {
        return Math.abs(x - other.x) +
        Math.abs(y - other.y) +
        Math.abs(z - other.z) +
        Math.abs(w - other.w);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pos pos = (Pos) o;

        if (x != pos.x) return false;
        if (y != pos.y) return false;
        if (z != pos.z) return false;
        return w == pos.w;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        result = 31 * result + w;
        return result;
    }
}
