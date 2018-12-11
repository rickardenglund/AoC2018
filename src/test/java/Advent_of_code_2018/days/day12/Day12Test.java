package Advent_of_code_2018.days.day12;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day12Test {
    
    @Test
    public void p1() {
        int expected = 2;
        String input = "";
        var sut = new Day12();
        assertEquals(expected, sut.getResultP1(input));
    }

}