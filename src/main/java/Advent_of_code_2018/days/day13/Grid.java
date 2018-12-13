package Advent_of_code_2018.days.day13;

public class Grid {
    private final Track[][] grid;

    public Grid(int width, int height) {
        grid = new Track[width][height];
    }

    public void add(int x, int y, char charAt) {
        grid[x][y] = new Track(charAt);
    }

    void print() {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y].toString();
            }

        }
    }
}
