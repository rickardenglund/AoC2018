package Advent_of_code_2018.days.day13;

import Advent_of_code_2018.util.Pos;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class Day13Test {

    @Test
    public void p1() {
        Pos expected = new Pos(7,3);
        String input =
                "/->-\\        \n" +
                "|   |  /----\\\n" +
                "| /-+--+-\\  |\n" +
                "| | |  | v  |\n" +
                "\\-+-/  \\-+--/\n" +
                "  \\------/   ";
        var sut = new Day13();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p2() {
        Optional<Pos> expected = Optional.of(new Pos(6, 4));
        String input =
                "/>-<\\  \n" +
                "|   |  \n" +
                "| /<+-\\\n" +
                "| | | v\n" +
                "\\>+</ |\n" +
                "  |   ^\n" +
                "  \\<->/";
        var sut = new Day13();
        assertEquals(expected, sut.getResultP2(input));
    }



}