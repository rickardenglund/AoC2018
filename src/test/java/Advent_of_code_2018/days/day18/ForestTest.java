package Advent_of_code_2018.days.day18;

import Advent_of_code_2018.util.Pos;
import org.junit.Test;

import static org.junit.Assert.*;

public class ForestTest {

    @Test
    public void countNeighbours() {
        int expected = 3;
        String input = "...\n###\n|||";
        var sut = Forest.create(input);
        assertEquals(expected, sut.countNeighBours(new Pos(1, 1), '.'));
        assertEquals(1, sut.countNeighBours(new Pos(0, 0), '.'));
        assertEquals(2, sut.countNeighBours(new Pos(1, 1), '#'));
    }

    @Test
    public void nextState() {
        String input = "...\n###\n|||";
        var sut = Forest.create(input);

        Character exp = '#';
        assertEquals(exp, sut.getNextState(new Pos(1, 1)));
        exp = '.';
        assertEquals(exp, sut.getNextState(new Pos(0, 0)));
        exp = '|';
        assertEquals(exp, sut.getNextState(new Pos(2, 2)));
    }

    @Test
    public void nextState2() {
        String input = ".|#\n||#\n|#|";
        var sut = Forest.create(input);

        sut.print();
        Character exp = '#';
        assertEquals(3, sut.countNeighBours(new Pos(1, 1), '#'));
        assertEquals(exp, sut.getNextState(new Pos(1, 1)));
        exp = '|';
        assertEquals(3, sut.countNeighBours(new Pos(0, 0), '|'));
        assertEquals(exp, sut.getNextState(new Pos(0, 0)));
        exp = '#';
        assertEquals(exp, sut.getNextState(new Pos(1, 2)));
    }

    @Test
    public void nextStateRemoveLumberYard() {
        String input = "...\n.#.\n...";
        var sut = Forest.create(input);

        sut.print();
        Character exp = '.';
        assertEquals(exp, sut.getNextState(new Pos(1, 1)));
    }

}