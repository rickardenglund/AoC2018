package Advent_of_code_2018.days.day18;

import Advent_of_code_2018.days.Day;

public class Day18 implements Day {
    @Override
    public Object getResultP1(String input) {
        Forest forest = Forest.create(input);
//        forest.print();
        for (int i = 0; i < 10; i++) {
        forest.tick();
        }
//        forest.print();
        return getResult(forest);
    }

    private Object getResult(Forest forest) {
        long wood = forest.countWood();
        long lumberYard = forest.countLumberYard();
        System.out.println("W: " + wood + " L: " + lumberYard);
        return wood * lumberYard;
    }

    @Override
    public Object getResultP2(String input) {

        Forest forest = Forest.create(input);
//        forest.print();
        for (int i = 0; i < 1_000_000_000; i++) {
            forest.tick();
            if (i % 100_000 == 0) {
                System.out.println(i);
                forest.print();
            }
        }
        forest.print();
        return getResult(forest);
    }

    @Override
    public int getDay() {
        return 18;
    }
}
