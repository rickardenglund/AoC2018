package Advent_of_code_2018.days.day16;

import java.util.Arrays;

public class TestData {
    public final int[] registersAfter  ;
    public final int[] instruction;
    public final int[] registersBefore;

    public TestData(String input) {
        var lines = input.split("\n");

        registersBefore = getArray(lines[0]);

        instruction = getArray(lines[1]);

        registersAfter = getArray(lines[2]);


    }

    public TestData(String line, String line1, String line2) {
        registersBefore = getArray(line);
        instruction = getArray(line1);
        registersAfter = getArray(line2);
    }

    private int[] getArray(String line) {
        return Arrays.stream(line.replaceAll("\\[|\\]|,|Before: |After:  ", "").split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    }

    public String[] cleanInput(String[] lines) {
        return Arrays.stream(lines)
                .map(it -> it.replaceAll("\\[|\\]|,|Before: |After:  ", ""))
                .toArray(String[]::new);
    }
}
