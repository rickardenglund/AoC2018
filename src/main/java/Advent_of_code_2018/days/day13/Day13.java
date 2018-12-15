package Advent_of_code_2018.days.day13;

import Advent_of_code_2018.days.Day;
import Advent_of_code_2018.util.Pos;

import java.util.Arrays;
import java.util.List;

public class Day13 implements Day {

    static {
        Pos.setSouthPositiveY();
    }

    @Override
    public Object getResultP1(String input) {
        String[] lines = input.split("\n");

        Grid grid = createGrid(lines);
        populateGrid(grid, lines);

        for (int i = 0; true; i++) {
            List<Pos> crashes = grid.tick(i);
            if (!crashes.isEmpty()) return crashes.get(0);
        }
    }

    @Override
    public Object getResultP2(String input) {
        String[] lines = input.split("\n");

        Grid grid = createGrid(lines);
        populateGrid(grid, lines);

        System.out.println("nTrains: " + grid.nTrains());
        for (int i = 0; true; i++) {
            List<Pos> crashes = grid.tick(i);
            if (grid.nTrains() < 2) {
                System.out.println("nTrains: " + grid.nTrains());
                return grid.getAnyTrainPos();
            }
        }
    }

    static void populateGrid(Grid grid, String[] lines) {
        for (int y = 0; y < lines.length; y++) {
            for (int x = 0; x < lines[y].length(); x++) {
                char newChar = lines[y].charAt(x);
                if (newChar != '/' && newChar != '\\') {
                    grid.add(x, y, new Track(newChar));
                } else {
                    boolean left = x > 0 && ">+<-".indexOf(lines[y].charAt(x - 1)) >= 0;
                    grid.add(x, y, new Track(newChar, left));
                }
            }
        }
    }

    static Grid createGrid(String[] lines) {
        int maxWidth = Arrays.stream(lines)
                .mapToInt(line -> line.length())
                .max().getAsInt();
        int height = lines.length;
        return new Grid(maxWidth, height);
    }

    @Override
    public int getDay() {
        return 13;
    }
}
