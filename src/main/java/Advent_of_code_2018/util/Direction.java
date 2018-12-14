package Advent_of_code_2018.util;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public static Direction opposite(Direction dir) {
        switch (dir) {
            case NORTH:
                return SOUTH;
            case EAST:
                return WEST;
            case SOUTH:
                return NORTH;
            case WEST:
                return EAST;
        }
        throw new RuntimeException("Unknown Direction: " + dir);
    }
}
