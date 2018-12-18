package Advent_of_code_2018.days.day18;

import Advent_of_code_2018.util.Direction;
import Advent_of_code_2018.util.Pos;

import java.util.Arrays;

public class Forest {
    private Character[][] map;
    private int height;
    private int width;

    private Forest(String input) {
        Pos.setSouthPositiveY();
        map = createMap(input);
    }

    private Character[][] createMap(String input) {
        String[] lines = input.split("\n");
        height = lines.length;
        width = lines[0].length();
        Character[][] map = new Character[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                map[x][y] = lines[y].charAt(x);
            }
        }
        return map;
    }

    public static Forest create(String input) {
        Forest forest = new Forest(input);
        return forest;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                sb.append(map[x][y]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void tick() {
        Character[][] nextMap = new Character[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                nextMap[x][y] = getNextState(new Pos(x, y));
            }
        }
        map = nextMap;
    }

    Character getNextState(Pos pos) {
        switch (get(pos)) {
            case '.':
                int openNeighbours = countNeighBours(pos, '|');
                if (openNeighbours > 2) return '|';
                return get(pos);
            case '#':
                int treeNeighbours = countNeighBours(pos, '|');
                int lumberYardNeighbours = countNeighBours(pos, '#');
                if (treeNeighbours > 0 && lumberYardNeighbours > 0) return '#';
                return '.';
            case '|':
                lumberYardNeighbours = countNeighBours(pos, '#');
                if (lumberYardNeighbours > 2) return '#';
                return get(pos);
        }
        throw new IllegalStateException("Unknown type: " + get(pos));
    }

    int countNeighBours(Pos pos, Character c) {
        int n = 0;
        Pos current = pos.clone();

        current.step(Direction.NORTH);
        if (is(c, current)) n++;
        current.step(Direction.EAST);
        if (is(c, current)) n++;
        current.step(Direction.SOUTH);
        if (is(c, current)) n++;
        current.step(Direction.SOUTH);
        if (is(c, current)) n++;
        current.step(Direction.WEST);
        if (is(c, current)) n++;
        current.step(Direction.WEST);
        if (is(c, current)) n++;
        current.step(Direction.NORTH);
        if (is(c, current)) n++;
        current.step(Direction.NORTH);
        if (is(c, current)) n++;
        return n;
    }

    private boolean is(Character c, Pos pos) {
        if (pos.getX() >= 0 && pos.getX() < width && pos.getY() >= 0 && pos.getY() < height) {
            return get(pos).equals(c);
        }
        return false;
    }

    private Character get(Pos pos) {
        return map[pos.getX()][pos.getY()];
    }

    private long count(Character c) {
        return Arrays.stream(map).flatMap(x -> Arrays.stream(x))
                .filter( x -> x.equals(c))
                .count();
    }

    public long countWood() {
        return count('|');
    }

    public long countLumberYard() {
        return count('#');
    }
}
