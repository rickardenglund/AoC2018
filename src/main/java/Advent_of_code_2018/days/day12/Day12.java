package Advent_of_code_2018.days.day12;

import Advent_of_code_2018.days.Day;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Day12 implements Day {
    private long nGens;

    @Override
    public Object getResultP1(String input) {
        nGens = 20;
        return letPlantsGrow(input);
    }

    @Override
    public Object getResultP2(String input) {
        StringBuilder finalState = new StringBuilder("#..#..#..#..#..#..#....#..#....#....#..#....#..#..#..#..#..#..#....#....#..#..#..#..#..#....#..#..#....#..#....#..#....#..#..#..#..#..#..#..#..#..#..#..#....#..#..#..#....#");

        return calcSum(finalState, 50000000000L - 72);
    }

    private int letPlantsGrow(String input) {
        String[] lines = input.split("\n");
        StringBuilder state = new StringBuilder("....." + lines[0].substring("initial state: ".length()) + ".....");

        Map<String, Character> map = createMap(lines);

        System.out.println("0: " + state.toString());

        StringBuilder newState = new StringBuilder();
        int firstValue = -5;
        for (long gen = 1; gen <= nGens; gen++) {

            firstValue = insertPadding(state, firstValue);

            newState = getNextState(state, map);

            if (gen % 1000_000 == 0) {
                System.out.println("Gen: " + gen + " size: " + newState.length() + " firstPos: " + firstPos(newState) + " first: " + firstValue);
            }
            printState(newState, firstValue, gen);

            state = newState;
        }

        return calcSum(newState, Long.valueOf(firstValue)).intValue();
    }

    BigInteger calcSum(StringBuilder newState, Long firstValue) {
        BigInteger sum = BigInteger.ZERO;
        for (int pot = 0; pot < newState.length(); pot++) {
            if (newState.charAt(pot) == '#') {
                sum = sum.add(BigInteger.valueOf(pot).add(BigInteger.valueOf(firstValue)));
            }
        }
        return sum;
    }

    private void printState(StringBuilder newState, int firstValue, long gen) {
        if (gen < 10) System.out.print(gen + " : " );
        else System.out.print(gen + ": " );
//        for (int i = 0; i < 5 + firstValue ; i++) {
//            System.out.print(".");
//        }
        System.out.print(newState.toString());
        System.out.println("first: " + firstValue);
    }

    StringBuilder getNextState(StringBuilder state, Map<String, Character> map) {
        StringBuilder newState;
        newState = new StringBuilder(".".repeat(state.length()));
        for (int pot = 2; pot < state.length() - 2; pot++) {
            String substring = state.substring(pot - 2, pot + 3);
            Character newStatus = map.get(substring);
            if (newStatus != null) {
                newState.setCharAt(pot, newStatus);
            } else {
                newState.setCharAt(pot, '.');//state.charAt(pot));
            }
        }
        return newState;
    }

    private int insertPadding(StringBuilder state, int firstValue) {
        if (insertAtStart(state)) {
            state.insert(0, "....");
            firstValue -= 4;
        } else if (removeAtStart(state)){
            state.delete(0, 2);
            firstValue += 2;
        }
        if (insertAtEnd(state)) {
            state.append("..");
        }
        return firstValue;
    }

    private Map<String, Character> createMap(String[] lines) {
        Map<String, Character> map = new HashMap<>();
        for (int i = 2; i < lines.length; i++) {
            String[] parts = lines[i].split(" ");
            map.put(parts[0], parts[2].charAt(0));
        }
        return map;
    }

    private boolean removeAtStart(StringBuilder state) {
        return firstPos(state) > 10;
    }

    private int firstPos(StringBuilder state) {
        return state.lastIndexOf("#");
    }

    private boolean insertAtEnd(StringBuilder state) {
        int res = firstPos(state);
        return res > state.length() - 4;
    }

    private boolean insertAtStart(StringBuilder state) {
        int res = state.indexOf("#");
        return res < 5;
    }



    @Override
    public int getDay() {
        return 12;
    }

    public void setGenerations(int nGens) {
        this.nGens = nGens;
    }
}
