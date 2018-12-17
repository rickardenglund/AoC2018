package Advent_of_code_2018.days.day17;

import Advent_of_code_2018.util.Pos;
import Advent_of_code_2018.util.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static Advent_of_code_2018.util.Direction.*;

public class Ground {
    private int width;
    private int height;
    private Character[][] map;
    private int wellPosition;

    public Ground() {
    }

    Character[][] getMap() {
        return map;
    }

    public Ground create(String input) {
        Pos.setSouthPositiveY();
        int maxX = 0;
        int minX = Integer.MAX_VALUE;
        int maxY = 0;
        int minY = Integer.MAX_VALUE;

        List<String[]> lines =
                input
                        .lines()
                        .map(it -> it.split(", "))
                        .map(parts -> Arrays.stream(parts)
                                .sorted()
                                .map(part -> part.substring(2))
                                .toArray(String[]::new))
                        .collect(Collectors.toList());

        List<Tuple<List<Integer>, List<Integer>>> coords = new ArrayList<>();
        for (var line : lines) {
            var xs = parse(line[0]);
            var ys = parse(line[1]);

            maxX = Math.max(maxX, xs.stream().max(Integer::compareTo).get());
            minX = Math.min(minX, xs.stream().min(Integer::compareTo).get());
            maxY = Math.max(maxY, ys.stream().max(Integer::compareTo).get());
            minY = Math.min(minY, ys.stream().min(Integer::compareTo).get());
            coords.add(new Tuple<>(xs, ys));
        }

        width = maxX - minX + 1 + 4;
        height = maxY - minY + 1;
        wellPosition = 500 - minX + 2;
        map = new Character[width][height];
        initmap();

        for (var tuple : coords) {
            for (int x : tuple.x) {
                for (int y : tuple.y) {
                    map[x - minX + 2][y - minY] = '#';
                }
            }
        }
        return new Ground();
    }

    private void initmap() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                map[x][y] = '.';
            }
        }
    }

    private static List<Integer> parse(String str) {
        List<Integer> res = new ArrayList<>();
        int[] parts = Arrays.stream(str.split("\\.\\.")).mapToInt(Integer::parseInt).toArray();
        if (parts.length == 1) {
            res.add(parts[0]);
            return res;
        } else {
            for (int i = parts[0]; i <= parts[1]; i++) {
                res.add(i);
            }
            return res;
        }
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (map[x][y] == '.') {
                    sb.append(' ');
                } else {
                    sb.append(map[x][y]);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void addWater() {
        addWater(new Pos(wellPosition, 0));
    }

    public void addWater(Pos pos) {

        try {
            set(pos, '|');
            while (canGoDown(pos)) {
                pos.step(SOUTH);
                set(pos, '|');
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        if (isAtBottom(pos)) {
            while (!searchHoleRight(pos.clone()) & !searchHoleLeft(pos.clone())) {
                fillRow(pos);
                pos.step(NORTH);
            }
        } else {
            Pos left = pos.clone();
            Pos right = pos.clone();
            try {
                if (searchHoleLeft(left)) {
                    addWater(left);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
            try {
                if (searchHoleRight(right)) {
                    addWater(right);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    private void fillRow(Pos pos) {
        Pos start = pos.clone();
        while (canGoLeft(start)) {
            start.step(WEST);
        }

        while (canGoRight(start)) {
            set(start, '~');
            start.step(EAST);
        }
        set(start, '~');
    }

    private boolean isAtBottom(Pos pos) {
        if (canGoDown(pos)) return false;
        Pos start = pos.clone();

        try {
            if (searchHoleLeft(start)) return false;

            start = pos.clone();
            return !searchHoleRight(start);
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean searchHoleLeft(Pos start) {
        set(start, '|');
        while (canGoLeft(start)) {
            if (canGoDown(start)) {
                return true;
            }
            start.step(WEST);
            set(start, '|');
        }
        return false;
    }

    private boolean searchHoleRight(Pos start) {
        set(start, '|');
        while (canGoRight(start)) {
            if (canGoDown(start)) {
                return true;
            }
            start.step(EAST);
            set(start, '|');
        }
        return false;
    }

    private boolean canGoDown(Pos pos) {
        return isFree(new Pos(pos.getX(), pos.getY() + 1));
    }

    private boolean isFree(Pos pos) {
        return get(pos) == '.' || get(pos) == '|';
    }

    private boolean canGoLeft(Pos pos) {
        return isFree(new Pos(pos.getX() - 1, pos.getY()));
    }

    private boolean canGoRight(Pos pos) {
        return isFree(new Pos(pos.getX() + 1, pos.getY()));
    }

    private char get(Pos pos) {
        return map[pos.getX()][pos.getY()];
    }

    private void set(Pos pos, char c) {
        map[pos.getX()][pos.getY()] = c;
    }

    public long countWater() {
        return Arrays.stream(map)
                .flatMap(x -> Arrays.stream(x))
                .filter(x -> '~' == x || '|' == x)
                .count();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public long countStillWater() {
        return Arrays.stream(map)
                .flatMap(x -> Arrays.stream(x))
                .filter(x -> '~' == x)
                .count();
    }
}
