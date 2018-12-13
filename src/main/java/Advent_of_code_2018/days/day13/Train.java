package Advent_of_code_2018.days.day13;

import Advent_of_code_2018.util.Direction;

public class Train {
    private Direction south;
    private int turns = 0;

    public Train(Direction direction) {
        this.south = direction;
    }
}
