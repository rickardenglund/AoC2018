package Advent_of_code_2018.days.day11;

import Advent_of_code_2018.days.Day;
import Advent_of_code_2018.util.Pos;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.IntStream;

public class Day11 implements Day {

    public static int powerLevel(int serialNumber, Pos pos) {
        long rackId = pos.getX() + 10;
        long powerLevel = rackId * pos.getY() + serialNumber;
        powerLevel *= rackId;
        String str = Long.toString(powerLevel);
        return Integer.parseInt("000" + str.charAt(str.length() - 3)) - 5;
    }

    @Override
    public Pos getResultP1(String input) {
        int serialNumber = Integer.parseInt(input);

        int[][] grid = generateGrid(serialNumber);

        return findMax(grid, 3).pos;
    }

    private int[][] generateGrid(int serialNumber) {
        int[][] grid = new int[300][300];

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = powerLevel(serialNumber, new Pos(x + 1, y + 1));
            }
        }
        return grid;
    }

    private static void printMask(int[][] grid, Pos pos) {
        System.out.println(pos);
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(grid[x + pos.getX()][y + pos.getY()] + " ");
            }
            System.out.println();
        }
    }

    public static Result findMax(int[][] grid, int kernelSize) {
        Pos bestPos = null;
        int bestSum = Integer.MIN_VALUE;
        for (int x = 0; x < grid.length - (kernelSize - 1); x++) {
            for (int y = 0; y < grid[x].length - (kernelSize - 1); y++) {

                int sum = sumMask(grid, x, y, kernelSize);
                if (sum > bestSum) {
                    bestPos = new Pos(x, y);
                    bestSum = sum;
                }
            }

        }
//        System.out.println(bestSum);
//        printMask(grid, bestPos);
        return new Result(bestPos.oneIndex(), kernelSize, bestSum);
    }

    private Result findMaxAnySize(int[][] grid) {
        Optional<Result> max = IntStream.range(1, 301)
                .parallel()
                .mapToObj(size -> findMax(grid, size))
                .max(Comparator.comparingInt(a -> a.value));

        return max.get();
    }

    public static int sumMask(int[][] grid, int xStart, int yStart, int kernelSize) {
        int sum = 0;
        for (int x = 0; x < kernelSize; x++) {
            for (int y = 0; y < kernelSize; y++) {
                sum += grid[xStart + x][yStart + y];
            }
        }
        return sum;
    }

    @Override
    public Result getResultP2(String input) {
        int serialNumber = Integer.parseInt(input);

        int[][] grid = generateGrid(serialNumber);

        return findMaxAnySize(grid);
    }

    @Override
    public int getDay() {
        return 11;
    }
}
