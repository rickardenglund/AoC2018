package Advent_of_code_2018.days.day18;

import Advent_of_code_2018.days.Day;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Integer> hashToTick = new HashMap<>();
        Forest forest = Forest.create(input);
        for (int i = 0; i < 512 + ((1_000_000_000 - 512) % 28); i++) {
            forest.tick();

//            String state = forest.toString();
//            Integer lastTick = hashToTick.get(state);

//            if (lastTick != null) {
//                System.out.println("Diff: " + (i - lastTick));
//                hashToTick.put(state, i);
//            } else {
//                hashToTick.put(state, i);
//            }

//            if (i % 28 == 0) {
//                System.out.println("I: " + i);
//                forest.print();
//            }
        }
        System.out.println("n: " + (512 + ((1_000_000_000 - 512) % 28)));
        forest.print();
        return getResult(forest);
    }

    @Override
    public int getDay() {
        return 18;
    }
}
