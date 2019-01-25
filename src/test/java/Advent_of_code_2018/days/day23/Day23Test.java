package Advent_of_code_2018.days.day23;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day23Test {

    @Test
    public void p1() {
        long expected = 7;
        String input = "pos=<0,0,0>, r=4\n" +
                "pos=<1,0,0>, r=1\n" +
                "pos=<4,0,0>, r=3\n" +
                "pos=<0,2,0>, r=1\n" +
                "pos=<0,5,0>, r=3\n" +
                "pos=<0,0,3>, r=1\n" +
                "pos=<1,1,1>, r=1\n" +
                "pos=<1,1,2>, r=1\n" +
                "pos=<1,3,1>, r=1";
        var sut = new Day23();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p2() {
        int expected = 36;
        String input = "pos=<10,12,12>, r=2\n" +
                "pos=<12,14,12>, r=2\n" +
                "pos=<16,12,12>, r=4\n" +
                "pos=<14,14,14>, r=6\n" +
                "pos=<50,50,50>, r=200\n" +
                "pos=<10,10,10>, r=5";
        var sut = new Day23();
        assertEquals(expected, sut.getResultP2(input));
    }

}