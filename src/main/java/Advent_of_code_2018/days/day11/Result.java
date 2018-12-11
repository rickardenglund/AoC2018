package Advent_of_code_2018.days.day11;

import Advent_of_code_2018.util.Pos;

public class Result {
    final public Pos pos;
    final public int size;
    public int value;

    public Result(Pos pos, int size, int value) {
        this.pos = pos;
        this.size = size;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Result{" +
                "pos=" + pos +
                ", size=" + size +
                ", value=" + value +
                '}';
    }
}