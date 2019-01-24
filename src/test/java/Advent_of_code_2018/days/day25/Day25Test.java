package Advent_of_code_2018.days.day25;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day25Test {

    @Test
    public void p1_1() {
        int expected = 2;
        String input = "0,0,0,0\n" +
                " 3,0,0,0\n" +
                " 0,3,0,0\n" +
                " 0,0,3,0\n" +
                " 0,0,0,3\n" +
                " 0,0,0,6\n" +
                " 9,0,0,0\n" +
                "12,0,0,0";
        var sut = new Day25();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1_2() {
        int expected = 4;
        String input = "-1,2,2,0\n" +
                "0,0,2,-2\n" +
                "0,0,0,-2\n" +
                "-1,2,0,0\n" +
                "-2,-2,-2,2\n" +
                "3,0,2,-1\n" +
                "-1,3,2,2\n" +
                "-1,0,-1,0\n" +
                "0,2,1,-2\n" +
                "3,0,0,0";
        var sut = new Day25();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Ignore
    @Test
    public void p2() {
        String expected = "";
        String input = "";
        var sut = new Day25();
        assertEquals(expected, sut.getResultP2(input));
    }

}