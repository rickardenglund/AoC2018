package Advent_of_code_2018.util;

import Advent_of_code_2018.days.day20.Room;

import java.util.Objects;

public class Pos {
    private int id;
    private int x;
    private int y;
    private static boolean yNorthPositive = true;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
        this.id = -1;
    }

    public Pos() {
        x = 0;
        y = 0;
        id = -1;
    }

    public Pos(int x, int y, int id) {
        this(x, y);
        this.id = id;
    }

    public static void setSouthPositiveY() {
        yNorthPositive = false;
    }

    public void step(Direction dir) {
        walk(dir, 1);
    }

    public void walk(Direction dir, int steps) {
        switch (dir) {
            case NORTH:
                y += (yNorthPositive? steps: -steps);
                break;
            case EAST:
                x += steps;
                break;
            case SOUTH:
                y -= (yNorthPositive? steps: -steps);
                break;
            case WEST:
                x -= steps;
                break;
        }
    }

    public int getDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    public Pos clone() {
        return new Pos(x, y);
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pos pos = (Pos) o;
        return x == pos.x &&
                y == pos.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getId() {
        return id;
    }

    public int getManhattanDistance(Pos other) {
        return Math.abs(getX() - other.getX()) + Math.abs(getY() - other.getY());
    }

    public Pos oneIndex() {
        return new Pos(x +1, y + 1);
    }

    public void set(Pos other) {
        x = other.x;
        y = other.y;
    }

}
