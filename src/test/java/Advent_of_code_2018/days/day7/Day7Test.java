package Advent_of_code_2018.days.day7;

import Advent_of_code_2018.days.Day;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day7Test {
    String input = "Step C must be finished before step A can begin.\n" +
            "Step C must be finished before step F can begin.\n" +
            "Step A must be finished before step B can begin.\n" +
            "Step A must be finished before step D can begin.\n" +
            "Step B must be finished before step E can begin.\n" +
            "Step D must be finished before step E can begin.\n" +
            "Step F must be finished before step E can begin.";
    @Test
    public void p1() {
        String expected = "CABDFE";
        Day sut = new Day7();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p2() {
        int expected = 15;
        Day sut = new Day7();

        assertEquals(expected, sut.getResultP1(input));
    }

}