package Advent_of_code_2018.days.day11;

import Advent_of_code_2018.util.Pos;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day11Test {

    @Test
    public void p1() {
        var sut = new Day11();
        String input = "18";

        assertEquals(33, sut.getResultP1(input).getX());
        assertEquals(45, sut.getResultP1(input).getY());
    }

    @Test
    public void p2() {
        var sut = new Day11();
        String input = "18";

        assertEquals(90, sut.getResultP2(input).pos.getX());
        assertEquals(269, sut.getResultP2(input).pos.getY());
        assertEquals(16, sut.getResultP2(input).size);
    }

    @Test
    public void p1a() {
        var sut = new Day11();
        String input = "42";

        assertEquals(21, sut.getResultP1(input).getX());
        assertEquals(61, sut.getResultP1(input).getY());
    }

    @Test
    public void calcPowerLevelA() {
        Pos pos = new Pos(3, 5);
        int serialNumber = 8;
        assertEquals(4, Day11.powerLevel(serialNumber, pos));
    }

    @Test
    public void calcPowerLevelB() {
        Pos pos = new Pos(217, 196);
        int serialNumber = 39;
        assertEquals(0, Day11.powerLevel(serialNumber, pos));
    }

    @Test
    public void calcPowerLevelC() {
        Pos pos = new Pos(122, 79);
        int serialNumber = 57;
        assertEquals(-5, Day11.powerLevel(serialNumber, pos));
    }

    @Test
    public void calcPowerLevelD() {
        Pos pos = new Pos(101, 153);
        int serialNumber = 71;
        assertEquals(4, Day11.powerLevel(serialNumber, pos));
    }

    @Test
    public void calcPowerLevelLarge() {
        Pos pos = new Pos(300, 300);
        int serialNumber = 1400;
        assertEquals(-5, Day11.powerLevel(serialNumber, pos));
    }


    @Test
    public void sumMask() {
        int [][]grid = {{4, 4, 4}, {3, 3, 4}, {1, 2, 4}};
        assertEquals(29, Day11.sumMask(grid, 0, 0, 3));
    }

    @Test
    public void findMax() {
        int [][]grid = {{-2, -4, 4, 4, 4}, {-4, 4, 4, 4, -5}, {4, 3, 3, 4, -4}, {1, 1, 2, 4, -3}, {-1, 0, 2, -5, -2}};
        assertEquals(2, Day11.findMax(grid, 3).pos.getX());
        assertEquals(2, Day11.findMax(grid, 3).pos.getY());
    }

    @Test
    public void findMaxB() {
        int [][]grid = {{4, 4, 4, -5}, {3, 3, 4, -4}, {1, 2, 4, -3}, { 0, 2, -5, -2}};
        assertEquals(1, Day11.findMax(grid, 3).pos.getX());
        assertEquals(1, Day11.findMax(grid, 3).pos.getY());
    }

    @Test
    public void findMaxC() {
        int [][]grid = {{-2, -4, 4, 4}, {-4, 4, 4, 4}, {4, 3, 3, 4}, {1, 1, 2, 4}, {-1, 0, 2, -5}};
        assertEquals(2, Day11.findMax(grid, 3).pos.getX());
        assertEquals(2, Day11.findMax(grid, 3).pos.getY());
    }
}