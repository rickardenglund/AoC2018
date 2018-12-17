package Advent_of_code_2018.days.day17;

import Advent_of_code_2018.days.Day;

public class Day17 implements Day {
    Ground ground;
    @Override
    public Object getResultP1(String input) {
        ground = new Ground();
        ground.create(input);
        fillGround(ground);

        ground.print();
        return ground.countWater();
    }

    private void fillGround(Ground ground) {
        long water = 0;
        while (true) {
            ground.addWater();
            long newWater = ground.countWater();
            if (water == newWater) {
                break;
            }
            water = newWater;
        }
    }

    @Override
    public Object getResultP2(String input) {
        if (ground == null) {
            ground = new Ground();
            ground.create(input);
            fillGround(ground);
        }
ground.print();
        return ground.countStillWater();
    }

    @Override
    public int getDay() {
        return 17;
    }
}
