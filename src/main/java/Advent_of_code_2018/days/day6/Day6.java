package Advent_of_code_2018.days.day6;

import Advent_of_code_2018.days.Day;
import Advent_of_code_2018.util.Pos;

import java.util.*;
import java.util.stream.Collectors;

public class Day6 implements Day {

    static int id = 1;
    int maxX = -1;
    int maxY = -1;
    private int radius = 10000;

    static int getNewId() {
        return id++;
    }

    @Override
    public Object getResultP1(String input) {
        List<Pos> dangers = parseInput(input);

        for (var pos : dangers) {
            maxX = Math.max(maxX, pos.getX());
            maxY = Math.max(maxY, pos.getY());
        }
        maxX++;
        maxY++;

        int[][] positions = createClosestMap(dangers);

        return sizeOfLargestArea(dangers, positions);
    }

    private int sizeOfLargestArea(List<Pos> dangers, int[][] positions) {
        HashSet<Object> edges = findEdges(positions);

        int maxArea = 0;
        for (var danger: dangers) {
            if (!edges.contains(danger.getId())) {
                maxArea = Math.max(maxArea, count(danger.getId(), positions));
            }
        }
        return maxArea;
    }

    private List<Pos> parseInput(String input) {
        return Arrays.stream(input.split("\n")).map(posStr -> createPos(posStr)).collect(Collectors.toList());
    }

    private HashSet<Object> findEdges(int[][] positions) {
        var edges = new HashSet<>();
        for (int x = 0; x < maxX; x++) {
            edges.add(positions[x][0]);
            edges.add(positions[x][maxY-1]);
        }

        for (int y = 0; y < maxY; y++) {
            edges.add(positions[0][y]);
            edges.add(positions[maxX - 1][y]);
        }
        return edges;
    }

    private int[][] createClosestMap(List<Pos> dangers) {
        int[][] positions = new int[maxX][maxY];
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                positions[x][y] = getClosest(new Pos(x, y), dangers);
            }
        }
        return positions;
    }

    private int count(int id, int[][] positions) {
        int cnt = 0;
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                if (positions[x][y] == id) cnt++;
            }
        }
        return cnt;
    }

    private int getClosest(Pos pos, List<Pos> dangers) {
        int minDistance = Integer.MAX_VALUE;
        int minId = -1;

        for (var danger : dangers) {
            int distance = pos.getManhattanDistance(danger);
            if (distance < minDistance) {
                minDistance = distance;
                minId = danger.getId();
            } else if (minDistance == distance) {
                minId = -1;
            }
        }
        return minId;
    }

    private Pos createPos(String posStr) {
        String[] parts = posStr.split(", ");

        return new Pos(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim()), getNewId());
    }

    @Override
    public Object getResultP2(String input) {
        List<Pos> safePos = parseInput(input);

        for (var pos : safePos) {
            maxX = Math.max(maxX, pos.getX());
            maxY = Math.max(maxY, pos.getY());
        }
        maxX++;
        maxY++;

        int[][] positions = new int[maxX][maxY];
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                int value = getSafeValue(new Pos(x, y), safePos);
                if (value < radius) {
                    positions[x][y] = 1;
                }
            }
        }

        return count(1, positions);
    }

    private int getSafeValue(Pos pos, List<Pos> safePos) {
        int value = 0;
        for (var other: safePos) {
            value += pos.getManhattanDistance(other);
        }
        return value;
    }

    @Override
    public int getDay() {
        return 6;
    }

    @Override
    public String getInput1() {
        return "61, 90\n" +
                "199, 205\n" +
                "170, 60\n" +
                "235, 312\n" +
                "121, 290\n" +
                "62, 191\n" +
                "289, 130\n" +
                "131, 188\n" +
                "259, 82\n" +
                "177, 97\n" +
                "205, 47\n" +
                "302, 247\n" +
                "94, 355\n" +
                "340, 75\n" +
                "315, 128\n" +
                "337, 351\n" +
                "73, 244\n" +
                "273, 103\n" +
                "306, 239\n" +
                "261, 198\n" +
                "355, 94\n" +
                "322, 69\n" +
                "308, 333\n" +
                "123, 63\n" +
                "218, 44\n" +
                "278, 288\n" +
                "172, 202\n" +
                "286, 172\n" +
                "141, 193\n" +
                "72, 316\n" +
                "84, 121\n" +
                "106, 46\n" +
                "349, 77\n" +
                "358, 66\n" +
                "309, 234\n" +
                "289, 268\n" +
                "173, 154\n" +
                "338, 57\n" +
                "316, 95\n" +
                "300, 279\n" +
                "95, 285\n" +
                "68, 201\n" +
                "77, 117\n" +
                "313, 297\n" +
                "259, 97\n" +
                "270, 318\n" +
                "338, 149\n" +
                "273, 120\n" +
                "229, 262\n" +
                "270, 136";
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
