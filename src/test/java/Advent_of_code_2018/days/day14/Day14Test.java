package Advent_of_code_2018.days.day14;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Day14Test {

    @Test
    public void p19() {
        String expected = "5158916779";
        String input = "9";
        var sut = new Day14();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1_15() {
        String expected = "0124515891";
        String input = "5";
        var sut = new Day14();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1_18() {
        String expected = "9251071085";
        String input = "18";
        var sut = new Day14();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1_2018() {
        String expected = "5941429882";
        String input = "2018";
        var sut = new Day14();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void createNewRecipe() {
        var sut = new Day14();
        List<Integer> newRecipes = sut.createNewRecipes(3, 7);
        assertTrue(newRecipes.containsAll(List.of(1, 0)));
    }

    @Test
    public void p2_9() {
        int expected = 9;
        String input = "51589";
        var sut = new Day14();
        assertEquals(expected, sut.getResultP2(input));
    }


    @Test
    public void p2_2018() {
        int expected = 2018;
        String input = "59414";
        var sut = new Day14();
        assertEquals(expected, sut.getResultP2(input));
    }

    @Test
    public void p2_5() {
        int expected = 5;
        String input = "01245";
        var sut = new Day14();
        assertEquals(expected, sut.getResultP2(input));
    }

    @Test
    public void p2_18() {
        int expected = 18;
        String input = "92510";
        var sut = new Day14();
        assertEquals(expected, sut.getResultP2(input));
    }

    @Test
    public void stringJoin() {
        var list = List.of(1,2,3);
        var expected = "123";
        String res = Day14.listToString(list);
        assertEquals(expected, res);
    }

    @Test
    public void listEq() {
        var list = List.of(1,2,3);
        var list2 = List.of(1, 1+1, 1+1+1);

        assertEquals(list, list2);
    }

    @Test
    public void reverseElves() {
        int[] elves = new int[]{1};
        Day14.reverseElves(elves, 5, 1);
        assertEquals(0, elves[0]);
    }

}