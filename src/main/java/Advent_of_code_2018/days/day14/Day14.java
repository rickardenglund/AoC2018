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

        int elf1Pos = 0;
        int elf2Pos = 1;
        var list = new ArrayList<>(List.of(3, 7));

        while (list.size() < afterXRecipes + 10) {
            List<Integer> newRecipes = createNewRecipes(list.get(elf1Pos), list.get(elf2Pos));
            list.addAll(newRecipes);
            elf1Pos = (list.get(elf1Pos) + elf1Pos + 1) % list.size();
            elf2Pos = (list.get(elf2Pos) + elf2Pos + 1) % list.size();
        }
        return listToString(list.subList(afterXRecipes, afterXRecipes + 10));
    }

    List<Integer> createNewRecipes(int a, int b) {
        int sum = a + b;
        int singles = sum % 10;

        if (sum > 9) {
            return List.of(1, singles);
        }
        return List.of(singles);
    }

    @Override
    public Object getResultP2(String input) {
        List<Integer> search = Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());

        int elf1Pos = 0;
        int elf2Pos = 1;
        List<Integer> list = new ArrayList<>(List.of(3, 7));

        while (true) {
            List<Integer> newRecipes = createNewRecipes(list.get(elf1Pos), list.get(elf2Pos));
            for (Integer r : newRecipes) {
                list.add(r);
                if (list.size() > search.size() && list.subList(list.size() - search.size(), list.size()).equals(search)) {
                    return list.size() - search.size();
                }
            }

            elf1Pos = (list.get(elf1Pos) + elf1Pos + 1) % list.size();
            elf2Pos = (list.get(elf2Pos) + elf2Pos + 1) % list.size();
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
