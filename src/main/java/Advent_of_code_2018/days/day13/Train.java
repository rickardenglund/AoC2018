package Advent_of_code_2018.days.day13;

import Advent_of_code_2018.util.Direction;

public class Train {
    private Direction direction;
    private int turns = 0;
    private int tick;

    public Train(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        switch (direction) {
            case NORTH:
                return "^";
            case EAST:
                return ">";
            case SOUTH:
                return "v";
            case WEST:
                return "<";
        }
        return "";
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getLastTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }
}
