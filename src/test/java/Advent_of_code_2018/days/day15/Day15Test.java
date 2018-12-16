package Advent_of_code_2018.days.day15;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day15Test {

    @Test
    public void p1() {
        int expected = 36334;
        String input =
                "#######\n" +
                "#G..#E#\n" +
                "#E#E.E#\n" +
                "#G.##.#\n" +
                "#...#E#\n" +
                "#...E.#\n" +
                "#######";

        String expStr =
                "#######   \n" +
                "#...#E#   E(200) \n" +
                "#E#...#   E(197) \n" +
                "#.E##.#   E(185) \n" +
                "#E..#E#   E(200), E(200) \n" +
                "#.....#   \n" +
                "#######   \n";
        var sut = new Day15();
        Object res = sut.getResultP1(input);
        assertEquals(expStr, sut.gridp1.toString());
        assertEquals(expected, res);
    }


    @Test
    public void p1FullExample() {
        int expected = 27730;
        String input =
                        "#######\n" +
                        "#.G...#\n" +
                        "#...EG#\n" +
                        "#.#.#G#\n" +
                        "#..G#E#\n" +
                        "#.....#\n" +
                        "#######";
        var sut = new Day15();
        assertEquals(expected, sut.getResultP1(input));

        String expectedstr =
                "#######   \n" +
                "#G....#   G(200) \n" +
                "#.G...#   G(131) \n" +
                "#.#.#G#   G(59) \n" +
                "#...#.#   \n" +
                "#....G#   G(200) \n" +
                "#######   \n";
        assertEquals(expectedstr, sut.gridp1.toString());
    }

    @Test
    public void p1e2() {
        String expectedStr =
                "#######   \n" +
                        "#.E.E.#   E(164), E(197) \n" +
                        "#.#E..#   E(200) \n" +
                        "#E.##.#   E(98) \n" +
                        "#.E.#.#   E(200) \n" +
                        "#...#.#   \n" +
                        "#######   \n";
        int expected = 39514;
        String input = "#######\n" +
                "#E..EG#\n" +
                "#.#G.E#\n" +
                "#E.##E#\n" +
                "#G..#.#\n" +
                "#..E#.#\n" +
                "#######";
        var sut = new Day15();
        Object res = sut.getResultP1(input);
        assertEquals(expectedStr, sut.gridp1.toString());
        assertEquals(expected, res);
    }

    @Test
    public void p1eLarge() {
        String expectedStr =
                "#########   \n" +
                        "#.G.....#   G(137) \n" +
                        "#G.G#...#   G(200), G(200) \n" +
                        "#.G##...#   G(200) \n" +
                        "#...##..#   \n" +
                        "#.G.#...#   G(200) \n" +
                        "#.......#   \n" +
                        "#.......#   \n" +
                        "#########   \n";
        int expected = 18740;
        String input =
                "#########\n" +
                "#G......#\n" +
                "#.E.#...#\n" +
                "#..##..G#\n" +
                "#...##..#\n" +
                "#...#...#\n" +
                "#.G...G.#\n" +
                "#.....G.#\n" +
                "#########";
        var sut = new Day15();
        sut.getResultP1(input);
        assertEquals(expectedStr, sut.gridp1.toString());
        assertEquals(expected, sut.getResultP1(input));
    }


}