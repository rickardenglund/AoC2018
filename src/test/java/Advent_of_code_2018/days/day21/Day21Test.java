package Advent_of_code_2018.days.day21;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day21Test {

    @Test
    public void p1() {
        var sut = new Day21();
        String input = sut.getInput1();
        assertEquals(11513432, sut.getResultP1(input));
    }

    @Test
    public void p2() {
        var sut = new Day21();
        int expected = 7434231;
        String input = sut.getInput2();
        assertEquals(expected, sut.getResultP2(input));
    }

}