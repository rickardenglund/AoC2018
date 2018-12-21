package Advent_of_code_2018.days.day20;

import Advent_of_code_2018.days.Day;

public class Day20 implements Day {
    private int minDoorsToRooms = 1000;

    @Override
    public Object getResultP1(String input) {
        FloorPlan floor = FloorPlan.create(input);
        floor.calculateDistances();

        return floor.getFarthestRoomDistance();
    }

    @Override
    public Object getResultP2(String input) {
        FloorPlan floor = FloorPlan.create(input);
        floor.calculateDistances();

        return floor.getRoomsWithNDoors(minDoorsToRooms);
    }

    @Override
    public int getDay() {
        return 20;
    }

    public void setMinDoorsToRooms(int minDoorsToRooms) {
        this.minDoorsToRooms = minDoorsToRooms;
    }
}
