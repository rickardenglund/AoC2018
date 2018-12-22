package Advent_of_code_2018.days.day22;

import Advent_of_code_2018.days.Day;

import java.util.HashMap;
import java.util.Map;

public class Day22 implements Day {

    Map<Pos3D, Long> geoIndexMap = new HashMap<>();
    @Override
    public Object getResultP1(String input) {
        String[] lines = input.split("\n");
        int depth = Integer.parseInt(lines[0].split(" ")[1]);
        Pos3D target = new Pos3D(lines[1].split(" ")[1], depth);

        int sum = 0;
        for (int y = 0; y <= target.y; y++) {
            for (int x = 0; x <= target.x; x++) {
                int groundType = (int)(calculateGeologicalLevel(new Pos3D(x, y, depth), target) % 3);
                System.out.print(toChar(groundType));
                sum += groundType;
            }
            System.out.println();
            
        }  

        return sum;
    }

    private String toChar(int groundType) {
        switch (groundType) {
            case 0: return ".";
            case 1: return "=";
            case 2: return "|";
        }
        throw new IllegalStateException();
    }


    long calculateGeologicalLevel(Pos3D pos, Pos3D target) {
        if (geoIndexMap.containsKey(pos)) return geoIndexMap.get(pos);

        if ((pos.x == 0 && pos.y == 0) ||
           (pos.equals(target))) {
            long level = indexToLevel(0, pos.depth);
            geoIndexMap.put(pos, level);
            return level;
        }

        if (pos.y == 0) {
            long level = indexToLevel(pos.x * 16807, pos.depth);
            geoIndexMap.put(pos, level);
            return level;
        }
        if (pos.x == 0) {
            long level = indexToLevel(pos.y * 48271, pos.depth);
            geoIndexMap.put(pos, level);
            return level;
        }

        long level = indexToLevel(
                calculateGeologicalLevel(new Pos3D(pos.x, pos.y - 1, pos.depth), target)
                * calculateGeologicalLevel(new Pos3D(pos.x - 1, pos.y, pos.depth), target), pos.depth);
        geoIndexMap.put(pos, level);
        return level;
    }

    private long indexToLevel(long index, int depth) {
        return (index + depth) % 20183;
    }

    @Override
    public Object getResultP2(String input) {
        return null;
    }

    @Override
    public int getDay() {
        return 22;
    }
}
