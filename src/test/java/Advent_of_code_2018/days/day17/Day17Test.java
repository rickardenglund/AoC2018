package Advent_of_code_2018.days.day17;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day17Test {

    @Test
    public void p1() {
        long expected = 57;
        String input = "x=495, y=2..7\n" +
                "y=7, x=495..501\n" +
                "x=501, y=3..7\n" +
                "x=498, y=2..4\n" +
                "x=506, y=1..2\n" +
                "x=498, y=10..13\n" +
                "x=504, y=10..13\n" +
                "y=13, x=498..504";
        var sut = new Day17();
        assertEquals(expected, sut.getResultP1(input));
    }


    @Test
    public void p12() {
        long expected = 69;
        String input = "" +
                "x=495, y=2..7\n" +
                "y=7, x=495..501\n" +
                "x=501, y=3..7\n" +
                "x=498, y=2..4\n" +
                "x=506, y=1..2\n" +
//                "x=498, y=10..13\n" +
                "x=504, y=10..13\n" +
                "y=13, x=495..504\n" +
                "x=495, y=10..13";
        var sut = new Day17();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p2() {
        long expected = 29;
        String input = "x=495, y=2..7\n" +
                "y=7, x=495..501\n" +
                "x=501, y=3..7\n" +
                "x=498, y=2..4\n" +
                "x=506, y=1..2\n" +
                "x=498, y=10..13\n" +
                "x=504, y=10..13\n" +
                "y=13, x=498..504";
        var sut = new Day17();
        assertEquals(expected, sut.getResultP2(input));
    }

}