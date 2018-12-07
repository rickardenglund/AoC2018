package Advent_of_code_2018.days.day7;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerTest {

    @Test
    public void letterToSeconds() {
        int expected = 4;
        assertEquals(expected, new Worker(0).letterToSeconds("D"));
    }

    @Test
    public void letterToSecondsOffset() {
        int expected = 11;
        var sut = new Worker(10);
        assertEquals(expected, sut.letterToSeconds("A"));
    }


    @Test
    public void letterToSecondsOffsetZ() {
        int expected = 36;
        var sut = new Worker(10);
        assertEquals(expected, sut.letterToSeconds("Z"));
    }
}