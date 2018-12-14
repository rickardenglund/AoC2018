package Advent_of_code_2018.days.day14;

import Advent_of_code_2018.days.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day14 implements Day {
    @Override
    public Object getResultP1(String input) {
        int afterXRecipes = Integer.parseInt(input);

        int[] elfPositions = new int[]{0, 1};
        var list = new ArrayList<>(List.of(3, 7));

        while (list.size() < afterXRecipes + 10) {
            List<Integer> newRecipes = createNewRecipes(list.get(elfPositions[0]), list.get(elfPositions[1]));
            list.addAll(newRecipes);
            updatePositions(elfPositions, list);
//            System.out.println(list);
//            System.out.println(Arrays.toString(elfPositions));
        }


        return listToString(list.subList(afterXRecipes, afterXRecipes + 10));
    }

    private void updatePositions(int[] elfPositions, List<Integer> list) {
        for (int i = 0; i < elfPositions.length; i++) {
            elfPositions[i] = (list.get(elfPositions[i]) + elfPositions[i] + 1) % list.size();
        }
    }

    List<Integer> createNewRecipes(Integer a, Integer b) {
        int sum = a + b;
        return Arrays.stream(Integer.toString(sum).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public Object getResultP2(String input) {
        System.out.println(Runtime.getRuntime().maxMemory());
        int[] elfPositions = new int[]{0, 1};
        List<Integer> list = new ArrayList<>(List.of(3, 7));
        var search = Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < search.size(); i++) {
            List<Integer> newRecipes = createNewRecipes(list.get(elfPositions[0]), list.get(elfPositions[1]));
            list.addAll(newRecipes);
            updatePositions(elfPositions, list);
        }


        while (true) {
            List<Integer> newRecipes = createNewRecipes(list.get(elfPositions[0]), list.get(elfPositions[1]));
            list.addAll(newRecipes);
            updatePositions(elfPositions, list);
            if (list.subList(list.size() - search.size(), list.size()).equals(search)) {
                return list.size() - search.size();
            }
            if (list.size() % 1_000_000== 0) System.out.println(list.size());
        }
    }

    static void reverseElves(int[] elfPositions, int size, int steps) {
        for (int i = 0; i < elfPositions.length; i++) {
            elfPositions[i] = (elfPositions[i] + size - steps) % size;
            if (elfPositions[i] > size - steps) elfPositions[i] -= steps;
        }
    }

    static String listToString(List<Integer> list) {
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    @Override
    public int getDay() {
        return 14;
    }
}
