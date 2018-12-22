package Advent_of_code_2018.days.day22;

import Advent_of_code_2018.days.Day;

import java.util.*;

import static Advent_of_code_2018.days.day22.Tool.*;

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
                Pos3D pos = new Pos3D(x, y, depth);
                int groundType = getGroundType(pos, target);
                System.out.print(toChar(groundType));
                sum += groundType;
            }
            System.out.println();

        }
        return sum;
    }

    private int getGroundType(Pos3D pos, Pos3D target) {
        return (int)(calculateGeologicalLevel(pos, target) % 3);
    }

    private String toChar(int groundType) {
        switch (groundType) {
            case 0:
                return ".";
            case 1:
                return "=";
            case 2:
                return "|";
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
        String[] lines = input.split("\n");
        int depth = Integer.parseInt(lines[0].split(" ")[1]);
        State start = new State(0, 0, depth, Torch);
        State target = new State(new Pos3D(lines[1].split(" ")[1], depth), Torch);

        return calculateDistances(start, target);
    }

    private int calculateDistances(State start, State target) {
        Set<State> visited = new HashSet<>();
        Queue<State> toVisit = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance.get() + o.estimatedDistance));
        start.distance = Optional.of(0);
        toVisit.add(start);

        return calculateDistances(toVisit, visited, target);
    }

    private int calculateDistances(Queue<State> toVisit, Set<State> visited, State target) {

        while (!toVisit.isEmpty() && !visited.contains(target)) {
            State pos = toVisit.poll();
            visited.add(pos);

            pos.getNeighbours().stream()
                    .filter(state -> !visited.contains(state))
                    .filter(state -> isAllowed(state, target.pos))
                    .peek(state -> state.distance = Optional.of(pos.distance.get() + cost(pos, state)))
                    .peek(state -> state.estimatedDistance = state.pos.manhattan(target.pos))
                    .forEach(toVisit::add);

            if (pos.equals(target)) return pos.distance.get();
        }
        return -1;
    }

    private Integer cost(State current, State next) {
        if (current.tool.equals(next.tool)) return 1;
        return 7;
    }

    private boolean isAllowed(State state, Pos3D target) {
        int groundType = getGroundType(state.pos, target);
        switch (groundType) {
            case 0: //rock
                return state.tool.equals(Rope) || state.tool.equals(Torch);
            case 1: //wet
                return state.tool.equals(Rope) || state.tool.equals(None);
            case 2: //narrow
                return state.tool.equals(None) || state.tool.equals(Torch);
        }
        throw new IllegalStateException();
    }


    @Override
    public int getDay() {
        return 22;
    }
}
