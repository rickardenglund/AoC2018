package Advent_of_code_2018.days.day16;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestDataTest {

    @Test
    public void createTestData() {
        String input = "Before: [3, 2, 1, 1]\n" +
                "9 2 1 2\n" +
                "After:  [3, 2, 2, 1]";

        TestData data= new TestData(input);


        assertArrayEquals(new int[]{3, 2, 1, 1}, data.registersBefore);
        assertArrayEquals(new int[]{9, 2, 1, 2}, data.instruction);
        assertArrayEquals(new int[]{3, 2, 2, 1}, data.registersAfter);

    }

}