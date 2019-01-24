package Advent_of_code_2018.days.day25;

import java.util.HashSet;
import java.util.Set;

public class Constellation {
    Set<Pos> nodes = new HashSet<>();

    public Constellation(Pos start) {
        nodes.add(start);
    }

    public boolean tryAdd(Pos pos) {
        if (isClose(pos)) {
            return nodes.add(pos);
        }
        return false;
    }


    private boolean isClose(Pos pos) {
        for (var p : nodes) {
            if (pos.distance(p) <= 3) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Pos pos) {
        return nodes.contains(pos);
    }
}
