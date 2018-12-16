package Advent_of_code_2018.days.day16.instructions;

public class Seti extends Instruction {
    @Override
    public int[] perform(int[] registers, int a, int b, int c) {
        registers[c] = a;
        return registers;
    }
}
