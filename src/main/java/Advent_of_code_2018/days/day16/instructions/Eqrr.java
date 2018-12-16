package Advent_of_code_2018.days.day16.instructions;

public class Eqrr extends Instruction {
    @Override
    public int[] perform(int[] registers, int a, int b, int c) {
        registers[c] = registers[a] == registers[b] ? 1: 0;
        return registers;
    }
}
