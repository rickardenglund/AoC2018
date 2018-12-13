package Advent_of_code_2018.days.day12;

import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class Day12Test {

    @Test
    public void p1() {
        int expected = 325;
        var sut = new Day12();
        sut.setGenerations(20);
        assertEquals(expected, sut.getResultP1(testInput));
    }

    @Test
    public void calcSum() {
        BigInteger expected = BigInteger.valueOf(7);
        var sb = new StringBuilder("..#..#");
        var sut = new Day12();
        assertEquals(expected, sut.calcSum(sb, Long.valueOf(0)));
    }

    @Test
    public void calcSumB() {
        BigInteger expected = BigInteger.valueOf(3);
        var sb = new StringBuilder("..#..#");
        var sut = new Day12();
        assertEquals(expected, sut.calcSum(sb, Long.valueOf(-2)));
    }

    @Test
    public void getNextStateA() {
        Map<String, Character> map = new HashMap<>();
        map.put("..#..", '#');

        String expected = "..#..";
        var sb = new StringBuilder("..#..");
        var sut = new Day12();
        assertEquals(expected, sut.getNextState(sb, map).toString());
    }

    @Test
    public void getNextStateB() {
        Map<String, Character> map = new HashMap<>();
        map.put("...##", '#');
        map.put(".##..", '#');
        map.put("..#..", '#');

        var sb = new StringBuilder("...##..##....");
        String expected = "..#.#...#....";
        var sut = new Day12();
        assertEquals(expected, sut.getNextState(sb, map).toString());
    }

    @Test
    public void getNextStateC() {
        Map<String, Character> map = new HashMap<>();
        map.put("..#..", '#');
        map.put(".#...", '#');

        String expected = "..##..";
        var sb = new StringBuilder("..#...");
        var sut = new Day12();
        assertEquals(expected, sut.getNextState(sb, map).toString());
    }

    String testInput = "initial state: #..#.#..##......###...###\n" +
            "\n" +
            "...## => #\n" +
            "..#.. => #\n" +
            ".#... => #\n" +
            ".#.#. => #\n" +
            ".#.## => #\n" +
            ".##.. => #\n" +
            ".#### => #\n" +
            "#.#.# => #\n" +
            "#.### => #\n" +
            "##.#. => #\n" +
            "##.## => #\n" +
            "###.. => #\n" +
            "###.# => #\n" +
            "####. => #";
}


