package Advent_of_code_2018.days.day19;

import Advent_of_code_2018.days.Day;

public class Day19 implements Day {
    @Override
    public Object getResultP1(String input) {
        CPU cpu = CPU.loadCPU(input);

        return cpu.run()[0];
    }

    @Override
    public Object getResultP2(String input) {
        CPU cpu = CPU.loadCPU(input);

        return "Dunno";//cpu.run(new int[] {1, 0, 0, 0, 0, 0});
    }



    @Override
    public int getDay() {
        return 19;
    }
}
