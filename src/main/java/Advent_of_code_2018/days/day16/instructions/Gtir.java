package Advent_of_code_2018.days.day16.instructions;

public class Gtir extends Instruction {
    @Override
    public int[] perform(int[] registers, int a, int b, int c) {
        registers[c] = a > registers[b] ? 1 : 0;
        return registers;
    }
}
