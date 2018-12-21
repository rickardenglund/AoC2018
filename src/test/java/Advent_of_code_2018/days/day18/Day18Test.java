package Advent_of_code_2018.days.day18;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day18Test {

    @Test
    public void p1() {
        long expected = 1147;
        String input = ".#.#...|#.\n" +
                ".....#|##|\n" +
                ".|..|...#.\n" +
                "..|#.....#\n" +
                "#.#|||#|#|\n" +
                "...#.||...\n" +
                ".|....|...\n" +
                "||...#|.#|\n" +
                "|.||||..|.\n" +
                "...#.|..|.";
        var sut = new Day18();
        assertEquals(expected, sut.getResultP1(input));
    }

}