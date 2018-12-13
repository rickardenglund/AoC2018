package Advent_of_code_2018.days.day13;

import Advent_of_code_2018.days.Day;

import java.util.Arrays;

public class Day13 implements Day {
    @Override
    public Object getResultP1(String input) {
        String[] lines = input.split("\n");
        Grid grid = createGrid(lines);
        
        populateGrid(grid, lines);

        return null;
    }

    private void populateGrid(Grid grid, String[] lines) {
        for (int y = 0; y < lines.length; y++) {
            for (int x = 0; x < lines[y].length(); x++) {
                grid.add(x,  y, lines[y].charAt(x));
            }
        }
    }

    private Grid createGrid(String[] lines) {
        int maxWidth = Arrays.stream(lines)
                .mapToInt(line -> line.length())
                .max().getAsInt();
        int height = lines.length;
        return new Grid(maxWidth, height);
    }

    @Override
    public Object getResultP2(String input) {
        return null;
    }

    @Override
    public int getDay() {
        return 13;
    }
}
