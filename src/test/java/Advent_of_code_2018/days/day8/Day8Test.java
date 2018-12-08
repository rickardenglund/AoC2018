package Advent_of_code_2018.days.day8;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day8Test {
    @Test
    public void testP1() {
        int expected = 138;
        String input = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2";
        var sut = new Day8();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void testP1oneNode() {
        int expected = 6;
        String input = "0 2 1 5";
        var sut = new Day8();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void testP1oneChild() {
        int expected = 8;
        String input = "1 1 0 2 1 5 2";
        var sut = new Day8();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void testP1twoChild() {
        int expected = 13;
        String input = "2 1 0 1 5 0 2 1 5 2";
        var sut = new Day8();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void testP2() {
        int expected = 66;
        String input = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2";
        var sut = new Day8();
        assertEquals(expected, sut.getResultP2(input));
    }

    @Test
    public void testP2oneNode() {
        int expected = 6;
        String input = "0 2 1 5";
        var sut = new Day8();
        assertEquals(expected, sut.getResultP2(input));
    }

    @Test
    public void testP2oneChild() {
        int expected = 12;
        String input = "1 2 0 2 1 5 1 1";
        var sut = new Day8();
        assertEquals(expected, sut.getResultP2(input));
    }

    @Test
    public void testP2twoChild() {
        int expected = 6;
        String input = "2 1 0 1 5 0 2 1 5 2";
        var sut = new Day8();
        assertEquals(expected, sut.getResultP2(input));
    }


}