package Advent_of_code_2018.days.day11;

import Advent_of_code_2018.days.Day;
import Advent_of_code_2018.util.Pos;

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

        System.out.println("Input: " + input);
        int[][] grid = new int[300][300];

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = powerLevel(serialNumber, new Pos(x + 1, y + 1));
            }
        }

        Pos max = findMax(grid);
        return max;
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

    public static Pos findMax(int[][] grid) {
        Pos bestPos = null;
        int bestSum = Integer.MIN_VALUE;
        for (int x = 0; x < grid.length - 2; x++) {
            for (int y = 0; y < grid[x].length - 2; y++) {

                int sum = sumMask(grid, x, y);
                if (sum > bestSum) {
                    bestPos = new Pos(x, y);
                    bestSum = sum;
                }
            }

        }
        System.out.println(bestSum);
        printMask(grid, bestPos);
        return bestPos.oneIndex();
    }

    public static int sumMask(int[][] grid, int xStart, int yStart) {
        int sum = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                sum += grid[xStart + x][yStart + y];
            }
        }
        return sum;
    }

    @Override
    public Object getResultP2(String input) {
        return getResultP1(input);
    }

    @Override
    public int getDay() {
        return 11;
    }
}
