package Advent_of_code_2018.days.day20;

import Advent_of_code_2018.util.Direction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Day20Test {

    @Test
    public void p1() {
        int expected = 3;
        String input = "^WNE$";
        var sut = new Day20();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p12() {
        int expected = 10;
        String input = "^ENWWW(NEEE|SSE(EE|N))$";
        var sut = new Day20();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p13() {
        int expected = 18;
        String input = "^ENNWSWW(NEWS|)SSSEEN(WNSE|)EE(SWEN|)NNN$";
        var sut = new Day20();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void matchingParenthesis() {
        String input = "(adlkfjas)asldkfj";
        assertEquals(9,FloorPlan.getMatchingParen(input, 0));
    }

    @Test
    public void matchingParenthesis2() {
        String input = "as(ldkfj)";
        assertEquals(8,FloorPlan.getMatchingParen(input, 2));
    }

    @Test
    public void matchingParenthesis3() {
        String input = "(a(sl)dkfj)";
        assertEquals(10,FloorPlan.getMatchingParen(input, 0));
    }

    @Test
    public void split() {
        String[] input = "NS|SE|".split("\\|", -1);

        assertEquals(3, input.length);
    }

    @Test
    public void p2() {
        long expected = 2;
        String input = "^WNE$";
        var sut = new Day20();
        sut.setMinDoorsToRooms(2);
        assertEquals(expected, sut.getResultP2(input));
    }

}