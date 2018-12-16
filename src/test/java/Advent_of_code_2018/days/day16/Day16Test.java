package Advent_of_code_2018.days.day16;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day16Test {

    @Test
    public void p1() {
        long
                expected = 1;
        String input =  "Before: [3, 2, 1, 1]\n" +
                "9 2 1 2\n" +
                "After:  [3, 2, 2, 1]";
        var sut = new Day16();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p2() {
        var sut = new Day16();
        int expected = 472;
        String input = sut.getInput2();
        assertEquals(expected, sut.getResultP2(input));
    }


    @Test
    public void createInstruction() {
        String input = "Before: [3, 2, 1, 1]\n" +
                "9 2 1 2\n" +
                "After:  [3, 2, 2, 1]";
        CPU cpu = new CPU();

        assertEquals(3, cpu.getPossibleInstructions(input).size());
    }

}