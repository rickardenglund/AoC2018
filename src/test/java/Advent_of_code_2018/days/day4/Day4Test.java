package Advent_of_code_2018.days.day4;

import Advent_of_code_2018.days.Day;
import Advent_of_code_2018.days.day3.Day3;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class Day4Test {
    final String testInput =
            "[1518-11-01 00:00] Guard #10 begins shift\n" +
                    "[1518-11-01 00:05] falls asleep\n" +
                    "[1518-11-01 00:25] wakes up\n" +
                    "[1518-11-01 00:30] falls asleep\n" +
                    "[1518-11-01 00:55] wakes up\n" +
                    "[1518-11-01 23:58] Guard #99 begins shift\n" +
                    "[1518-11-02 00:40] falls asleep\n" +
                    "[1518-11-02 00:50] wakes up\n" +
                    "[1518-11-03 00:05] Guard #10 begins shift\n" +
                    "[1518-11-03 00:24] falls asleep\n" +
                    "[1518-11-03 00:29] wakes up\n" +
                    "[1518-11-04 00:02] Guard #99 begins shift\n" +
                    "[1518-11-04 00:36] falls asleep\n" +
                    "[1518-11-04 00:46] wakes up\n" +
                    "[1518-11-05 00:03] Guard #99 begins shift\n" +
                    "[1518-11-05 00:45] falls asleep\n" +
                    "[1518-11-05 00:55] wakes up";

    @Test
    public void p1() {
        Long expected = Long.valueOf(240);
        Day sut = new Day4();
        assertEquals(expected, sut.getResultP1(testInput));
    }

    @Test
    public void p2() {
        Long expected = Long.valueOf(4455);
        Day sut = new Day4();
        assertEquals(expected, sut.getResultP2(testInput));
    }

    @Test
    public void testFindGuard() {
        Long expected = Long.valueOf(10);
        Day sut = new Day4();
//        assertEquals(expected, sut.getMostSleepy());
    }

    @Test
    public void testParseDate() {
        String dateStr = "[1518-11-01 00:05]";

        LocalDateTime expected = LocalDateTime.of(1518, 11, 1, 0, 5);
        assertEquals(expected, new Day4().parseDate(dateStr));
    }


}