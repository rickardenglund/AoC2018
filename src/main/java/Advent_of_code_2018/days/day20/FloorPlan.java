package Advent_of_code_2018.days.day20;

import Advent_of_code_2018.util.Direction;
import Advent_of_code_2018.util.Pos;

import java.util.*;
import java.util.stream.Collectors;

import static Advent_of_code_2018.util.Direction.*;

public class FloorPlan {
    Map<Pos, Room> rooms = new HashMap<>();

    private FloorPlan(String input) {
        Pos pos = new Pos(0, 0);
        visit(pos);

        int i = 1;
        while (input.charAt(i) != '$') {
            i += travel(input.substring(i), pos);
        }
    }

    private int travel(String str, Pos pos) {
        if (str.length() == 0) return 0;
        int visited = 0;
        if (str.charAt(visited) != '(' && str.charAt(visited) != '$') {
            char current;
            while (visited < str.length() && (current = str.charAt(visited)) != '(' && current != '$') {
                walk(pos, str.charAt(visited));
                visited++;
            }
            return visited;
        }

        int matchingParen = getMatchingParen(str, 0);
        String inParen = str.substring(1, matchingParen);

        var parts = split(inParen);
        Pos start = pos.clone();
        for (var part : parts) {
            int i = 0;
            pos.set(start);
            while (i < part.length()) {
                i += travel(part.substring(i), pos);
            }
        }
        return inParen.length() + 2;
    }

    private List<String> split(String str) {
        List<String> parts = new ArrayList<>();
        int i = 0;
        int partStart = i;
        while (i < str.length()) {
            char current = str.charAt(i);
            switch (current) {
                case '(':
                    int matching = getMatchingParen(str, i);
                    i = matching + 1;
                    break;
                case '|':
                    parts.add(str.substring(partStart, i));
                    i++;
                    partStart = i;
                    break;
                default:
                    i++;
                    break;
            }
        }
        if (partStart < str.length()) {
            parts.add(str.substring(partStart));
        }
        return parts;
    }

    static int getMatchingParen(String dirs, int firstParen) {
        int nStarted = 1;
        for (int i = firstParen + 1; i < dirs.length(); i++) {
            if (dirs.charAt(i) == '(') nStarted++;
            if (dirs.charAt(i) == ')') nStarted--;

            if (nStarted == 0) return i;
        }

        throw new IllegalStateException("Invalid string: " + dirs);
    }

    private void walk(Pos pos, char dirChar) {
        Direction dir = getDir(dirChar);

        rooms.get(pos).addDoor(dir);
        pos.step(dir);
        Room newRoom = visit(pos);
        newRoom.addDoor(opposite(dir));
    }

    private Direction getDir(char dirChar) {
        switch (dirChar) {
            case 'W':
                return WEST;
            case 'E':
                return EAST;
            case 'N':
                return NORTH;
            case 'S':
                return SOUTH;
        }
        throw new IllegalStateException("Invalid direction: " + dirChar);
    }

    private Room visit(Pos pos) {
        Room room = rooms.get(pos);
        if (room == null) {
            room = new Room();
            rooms.put(pos.clone(), room);
        }
        return room;
    }

    public static FloorPlan create(String input) {
        Pos.setSouthPositiveY();
        return new FloorPlan(input);
    }

    public int getFarthestRoomDistance() {
        return rooms.values().stream()
                .mapToInt(Room::getDistance)
                .max().getAsInt();
    }



    public long getRoomsWithNDoors(int nDoors) {
        return rooms.values().stream()
                .mapToInt(Room::getDistance)
                .filter(d -> d >= nDoors)
                .count();
    }

    public void calculateDistances() {
        Set<Pos> visited = new HashSet<>();
        Deque<Pos> toVisit = new ArrayDeque<>();
        toVisit.add(new Pos(0, 0));

        while (!toVisit.isEmpty()) {
            Pos pos = toVisit.poll();
            visited.add(pos);
            Room currentRoom = rooms.get(pos);

            List<Pos> neighbours = getNeighbours(pos, currentRoom);
            neighbours.stream()
                    .filter(p -> !visited.contains(p))
                    .peek(toVisit::add)
                    .map(rooms::get)
                    .forEach(room -> room.setDistance(currentRoom.getDistance() + 1));
        }
    }

    public List<Pos> getNeighbours(Pos pos, Room room) {
        return room.getDoors().stream().map(dir -> {
            Pos clone = pos.clone();
            clone.step(dir);
            return clone;
        }).collect(Collectors.toList());
    }

}
