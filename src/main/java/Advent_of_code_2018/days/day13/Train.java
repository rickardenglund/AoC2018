package Advent_of_code_2018.days.day13;

import Advent_of_code_2018.util.Direction;

import static Advent_of_code_2018.util.Direction.*;
import static Advent_of_code_2018.util.Direction.NORTH;

public class Train {
    private Direction direction;
    private int crossingCounter = 0;
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

    void crossingTurn() {
        switch (getDirection()) {
            case NORTH:
                direction = turn(WEST, NORTH, EAST);
                break;
            case EAST:
                direction = turn(NORTH, EAST, SOUTH);
                break;
            case SOUTH:
                direction = turn(EAST, SOUTH, WEST);
                break;
            case WEST:
                direction = turn(SOUTH, WEST, NORTH);
                break;
        }
        crossingCounter++;
    }

    private Direction turn(Direction left, Direction straight, Direction right) {
        switch (crossingCounter % 3) {
            case 0: return left;
            case 1: return straight;
            case 2: return right;
        }
        throw new IllegalStateException("Bad mojo");
    }

    public int getLastTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public int getCrossingCounter() {
        return crossingCounter;
    }
}
