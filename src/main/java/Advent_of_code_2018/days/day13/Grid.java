package Advent_of_code_2018.days.day13;

import Advent_of_code_2018.util.Pos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Grid {
    private final Track[][] grid;

    public Grid(int width, int height) {
        grid = new Track[width][height];
    }

    Track[][] getGrid() {
        return grid;
    }

    public void add(int x, int y, Track track) {
        grid[x][y] = track;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < grid[0].length; y++) {
            for (int x = 0; x < grid.length; x++) {
                sb.append(grid[x][y].toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<Pos> tick(int currentTick) {
        List<Pos> crashes = new ArrayList<>();
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
                            grid[newPos.getX()][newPos.getY()].takeTrain();
                            crashes.add(newPos);
                        }
                    }
                }
            }
        }

        return crashes;
    }

    public long nTrains() {
        return Arrays.stream(grid).flatMap(Arrays::stream)
                .filter(track -> track.train.isPresent())
                .count();
    }

    public Optional<Pos> getAnyTrainPos() {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y].train.isPresent()) return Optional.of(new Pos(x, y));
            }
        }
        return Optional.empty();
    }

    public int getWidth() {
        return grid.length;
    }

    public int getHeight() {
        return grid[0].length;
    }
}
