package Advent_of_code_2018.days.day9;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day9Test {
    @Test
    public void p1() {
        long expected = 32;
        String input = "9 25";
        var sut = new Day9();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1a() {
        long expected = 8317;
        String input = "10 1618";
        var sut = new Day9();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1b() {
        long expected = 146373;
        String input = "13 7999";
        var sut = new Day9();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1c() {
        long expected = 2764;
        String input = "17 1104";
        var sut = new Day9();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1d() {
        long expected = 54718;
        String input = "21 6111";
        var sut = new Day9();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1e() {
        long expected = 37305;
        String input = "30 5807";
        var sut = new Day9();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1small() {
        long expected = 0;
        String input = "5 10";
        var sut = new Day9();
        assertEquals(expected, sut.getResultP1(input));
    }

}