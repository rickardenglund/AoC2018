package Advent_of_code_2018.days.day16.instructions;

public class Muli extends Instruction {

    @Override
    public int[] perform(int[] registers, int a, int b, int c) {
        registers[c] = registers[a] * b;
        return registers;
    }
}
