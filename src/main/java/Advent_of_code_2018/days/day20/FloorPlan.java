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
        String dirs = input.substring(1, input.length() - 1);
        Set<String> paths = createPaths(dirs);

        for (var path : paths) {
            pos = new Pos(0, 0);
            for (var dir : path.toCharArray()) {
                walk(pos, dir);
            }
            System.out.println("Path: " + path);
        }
    }

    static Set<String> createPaths(String toVisit) {
        Set<String> paths = new HashSet<>();
        int firstParen = toVisit.indexOf("(");
        if (firstParen == -1) {
            paths.add(toVisit);
            return paths;
        }


        int matchingParen = getMatchingParen(toVisit, firstParen);
        String currentPath = toVisit.substring(0, firstParen);
        String insideParenthesis = toVisit.substring(firstParen + 1, matchingParen);

        if (insideParenthesis.indexOf('(') == -1) {
            for (var str : insideParenthesis.split("\\|", -1)) {
                var more = createPaths(str + toVisit.substring(matchingParen + 1));
                for (var path : more) {
                    paths.add(currentPath + path);
                }
            }
            return paths;
        } else {
            String parenContent = toVisit.substring(firstParen + 1, matchingParen);
            int paren = parenContent.indexOf('(');
            int matching = getMatchingParen(parenContent, paren);
            Set<String> list = createPaths(insideParenthesis.substring(paren, matching + 1));

            List<String> l2 = list.stream().map(l ->
            currentPath + "(" + insideParenthesis.substring(0, paren) + l + insideParenthesis.substring(matching) + toVisit.substring(matchingParen + 1))
            .collect(Collectors.toList());

            for (var l : l2) {
                paths.addAll(createPaths(l));
            }
        }
        return paths;
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
}
