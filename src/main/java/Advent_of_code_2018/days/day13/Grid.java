package Advent_of_code_2018.days.day13;

import Advent_of_code_2018.util.Pos;

import java.util.ArrayList;
import java.util.Optional;

public class Grid {
    private final Track[][] grid;

    public Grid(int width, int height) {
        grid = new Track[width][height];
    }

    public void add(int x, int y, Track track) {
        grid[x][y] = track;
    }

    void print() {
        for (int y = 0; y < grid[0].length; y++) {
            for (int x = 0; x < grid.length; x++) {
                System.out.print(grid[x][y].toString());
            }
            System.out.println();
        }
    }

    public void tick(int currentTick) {
        for (int y = 0; y < grid[0].length; y++) {
            for (int x = 0; x < grid.length; x++) {
                Optional<Pos> maybeNewPos = grid[x][y].getNewTrainPos(new Pos(x, y), currentTick);
                if (maybeNewPos.isPresent()) {
                    Train train = grid[x][y].takeTrain();
                    Pos newPos = maybeNewPos.get();
                    try {
                        grid[newPos.getX()][newPos.getY()].setTrain(train, currentTick + 1);
                    } catch (RuntimeException e ) {
                        if (e.getMessage().equals("Train Crash")) {
                            System.out.println("Train Crash at : " + newPos);
                            throw e;
                        }
                    }
                }
            }
        }

    }
}
