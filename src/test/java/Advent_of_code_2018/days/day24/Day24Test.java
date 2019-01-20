package Advent_of_code_2018.days.day24;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day24Test {

    private final String input = "Immune System:\n" +
            "17 units each with 5390 hit points (weak to radiation, bludgeoning) with" +
            " an attack that does 4507 fire damage at initiative 2\n" +
            "989 units each with 1274 hit points (immune to fire; weak to bludgeoning," +
            " slashing) with an attack that does 25 slashing damage at initiative 3\n" +
            "\n" +
            "Infection:\n" +
            "801 units each with 4706 hit points (weak to radiation) with an attack" +
            " that does 116 bludgeoning damage at initiative 1\n" +
            "4485 units each with 2961 hit points (immune to radiation; weak to fire," +
            " cold) with an attack that does 12 slashing damage at initiative 4";

    @Test
    public void p1() {
        int expected = 5216;
        var sut = new Day24();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void testBoost() {
        int boost = 1570;
        var sut = new Day24();
        sut.setBoost(boost);
        assertEquals(51, sut.getResultP1(input));
    }

    @Test
    public void p2() {
        int expected = 51;
        var sut = new Day24();
        assertEquals(expected, sut.getResultP2(input));
    }

}