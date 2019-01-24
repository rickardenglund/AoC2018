package Advent_of_code_2018.days.day25;

import Advent_of_code_2018.days.Day;

import java.util.*;
import java.util.stream.Collectors;

public class Day25 implements Day {
    @Override
    public Object getResultP1(String input) {
        List<Pos> poss = input.lines().map(it -> new Pos(it)).collect(Collectors.toList());
        List<Constellation> cons = new ArrayList<>();

        Optional<Pos> maybeP;
        while ((maybeP = firstNewPos(cons, poss)).isPresent()) {
            Pos p = maybeP.get();
            Constellation con = createConstellation(p, poss);
            cons.add(con);
        }

        return cons.size();
    }

    private Optional<Pos> firstNewPos(List<Constellation> cons, List<Pos> poss) {
        for (var pos: poss) {
            if (cons.stream().allMatch(con -> !con.contains(pos))) {
                return Optional.of(pos);
            }
        }
        return Optional.empty();
    }


    private Constellation createConstellation(Pos start, List<Pos> poss) {
        var con = new Constellation(start);
        boolean more = true;
        while (more) {
            more = false;
            for (var pos : poss) {
                more |= con.tryAdd(pos);
            }
        }
        return con;
    }



    @Override
    public Object getResultP2(String input) {
        return null;
    }

    @Override
    public int getDay() {
        return 25;
    }
}
