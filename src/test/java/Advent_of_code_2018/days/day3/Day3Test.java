package Advent_of_code_2018.days.day3;

import Advent_of_code_2018.days.Day;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Day3Test {
    @Test
    public void p1t2() {
        String input = "#1 @ 1,3: 4x4\n" +
                "#2 @ 3,1: 4x4\n" +
                "#3 @ 5,5: 2x2";
        int expected = 4;
        Day sut = new Day3();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void createClaim() {
        Day3 sut = new Day3();
        Claim claim = sut.createClaim("#2 @ 3,1: 4x4");
        assertEquals(2, claim.getId());
        assertEquals(3, claim.getXpos());
        assertEquals(1, claim.getYpos());
        assertEquals(4, claim.getWidth());
        assertEquals(4, claim.getHeight());
    }

    @Test
    public void insertClaim() {
        Day3 sut = new Day3();
        Claim claim = sut.createClaim("#2 @ 3,1: 4x4");
        String[][] sheet = new String[50][50];
        sut.insert(sheet, claim, List.of(claim));

        assertEquals("2", sheet[3][1]);
    }

    @Test
    public void insertIntersectClaim() {
        Day3 sut = new Day3();
        Claim claim = sut.createClaim("#1 @ 7,1: 4x4");
        String[][] sheet = new String[50][50];
        sut.insert(sheet, claim, List.of(claim));
        sut.insert(sheet, claim, List.of(claim));
        assertEquals("X", sheet[7][1]);
    }
}