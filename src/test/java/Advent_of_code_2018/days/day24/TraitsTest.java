package Advent_of_code_2018.days.day24;

import org.junit.Test;

import static org.junit.Assert.*;

public class TraitsTest {
    @Test
    public void testParseImmunities() {
        String str = "(immune to slashing, radiation)";
        Traits traits = Traits.parseTraits(str);
        assertTrue(traits.isImmuneTo("slashing"));
        assertFalse(traits.isImmuneTo("fire"));
    }

    @Test
    public void testParseWeaknesses() {
        String str = "(immune to cold; weak to radiation, water)";
        Traits traits = Traits.parseTraits(str);
        assertTrue(traits.isImmuneTo("cold"));
        assertFalse(traits.isImmuneTo("fire"));

        assertTrue(traits.isWeakTo("radiation"));
        assertTrue(traits.isWeakTo("water"));
        assertFalse(traits.isWeakTo("sun"));
    }

    @Test
    public void parseEmpty() {
        Traits traits = Traits.parseTraits("");
    }

}