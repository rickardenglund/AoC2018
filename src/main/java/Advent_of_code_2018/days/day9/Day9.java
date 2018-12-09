package Advent_of_code_2018.days.day9;

import Advent_of_code_2018.days.Day;
import Advent_of_code_2018.util.Tuple;

import java.util.*;

public class Day9 implements Day {
    @Override
    public Object getResultP1(String input) {
        int nPlayers = Integer.parseInt(input.split(" ")[0]);
        int lastMarble = Integer.parseInt(input.split(" ")[1]);
        int currentPlayer = nPlayers - 1;
        long[] score = new long[nPlayers];

        Circle<Integer> marbles = new Circle<>(0);
        int currentMarble = 1;
        while (currentMarble <= lastMarble) {
            currentPlayer = (currentPlayer + 1) % nPlayers;
            if (currentMarble % 23 != 0) {
                marbles.next();
                marbles.add(currentMarble++);
            } else {
                score[currentPlayer] += currentMarble;
                currentMarble++;
                marbles.back(7);

                int removed = marbles.remove();
                score[currentPlayer] += removed;
            }

        }
        return Arrays.stream(score).max().getAsLong();
    }

    private Tuple<ListIterator<Integer>, Integer> stepBack(ListIterator<Integer> iterator, LinkedList<Integer> marbles, int steps) {
        for (int i = 0; i < steps; i++) {
            if (!iterator.hasPrevious()) {
                iterator = marbles.listIterator(marbles.size() - 1);
            } else {
                iterator.previous();
            }
        }

        if (iterator.hasPrevious()) {
            iterator.previous();
        } else {
            iterator = marbles.listIterator(marbles.size() - 2);
        }
        Integer value = iterator.next();

        return new Tuple<>(iterator, value);
    }

    @Override
    public Object getResultP2(String input) {
        String players = getInput1().split(" ")[0];
        int lastMarble = Integer.parseInt(getInput1().split(" ")[1]);

        return getResultP1(players + " " + lastMarble * 100);
    }

    @Override
    public int getDay() {
        return 9;
    }

    @Override
    public String getInput1() {
        return "419 72164";
    }

}

