package Advent_of_code_2018.days.day5;

import Advent_of_code_2018.days.Day;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day5Test {
    @Test
    public void p1() {
        String input = "dabAcCaCBAcCcaDA";
        int expected = 10;
        Day sut = new Day5();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1short() {
        String input = "aA";
        int expected = 0;
        Day sut = new Day5();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1short2() {
        String input = "abBA";
        int expected = 0;
        Day sut = new Day5();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1short3() {
        String input = "aabAAB";
        int expected = 7;
        Day sut = new Day5();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p2() {
        String input = "dabAcCaCBAcCcaDA";
        int expected = 4;
        Day sut = new Day5();
        assertEquals(expected, sut.getResultP2(input));
    }

    @Test
    public void test() {
        char a = 'B';
        char A = 'b';
        assertEquals(Math.abs(a - A), 32);
    }
}