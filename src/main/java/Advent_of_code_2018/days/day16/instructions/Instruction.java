package Advent_of_code_2018.days.day16.instructions;

import Advent_of_code_2018.days.day16.TestData;

import java.util.Arrays;

public abstract class Instruction {
    public boolean matches(TestData data) {
        var res = perform(data.registersBefore.clone(), data.instruction[1], data.instruction[2], data.instruction[3]);
        return Arrays.equals(data.registersAfter, res);
    }

    public abstract int[] perform(int[] registers, int a, int b, int c);
}
