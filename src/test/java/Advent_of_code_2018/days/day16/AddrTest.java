package Advent_of_code_2018.days.day16;

import Advent_of_code_2018.days.day16.instructions.Addi;
import Advent_of_code_2018.days.day16.instructions.Addr;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddrTest {

    @Test
    public void testMatches() {
        String input = "Before: [3, 2, 1, 1]\n" +
                "9 2 1 2\n" +
                "After:  [3, 2, 2, 1]";

        var data = new TestData(input);

        assertTrue(new Addi().matches(data));
        assertFalse(new Addr().matches(data));
    }

}