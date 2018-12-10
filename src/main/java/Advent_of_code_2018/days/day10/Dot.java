package Advent_of_code_2018.days.day10;

import Advent_of_code_2018.util.Pos;

public class Dot {
    private final int x;
    private final int y;
    private final int xs;
    private final int ys;

    public Dot(int x, int y, int xs, int ys) {
        this.x = x;
        this.y = y;
        this.xs = xs;
        this.ys = ys;
    }

    public Pos getPos(int time) {
        return new Pos(x + xs*time, y+ys*time);
    }
}
