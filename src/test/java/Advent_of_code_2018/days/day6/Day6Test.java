package Advent_of_code_2018.days.day6;

import Advent_of_code_2018.days.Day;
import Advent_of_code_2018.days.day5.Day5;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day6Test {

    String input = "1, 1\n" +
            "        1, 6\n" +
            "        8, 3\n" +
            "        3, 4\n" +
            "        5, 5\n" +
            "        8, 9";

    @Test
    public void p1() {
        int expected = 17;
        Day sut = new Day6();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p2() {
        int expected = 16;
        Day sut = new Day6();
        ((Day6)sut).setRadius(32);
        assertEquals(expected, sut.getResultP2(input));
    }
}