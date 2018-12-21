package Advent_of_code_2018.days.day20;

import Advent_of_code_2018.util.Direction;

import java.util.HashSet;
import java.util.Set;

public class Room {
    private Set<Direction> doors = new HashSet<>();
    private int distance;

    public void addDoor(Direction direction) {
        doors.add(direction);
    }

    public boolean hasDoor(Direction dir) {
        return doors.contains(dir);
    }

    public Set<Direction> getDoors() {
        return doors;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distanceToCenter) {
        distance = distanceToCenter;
    }
}
