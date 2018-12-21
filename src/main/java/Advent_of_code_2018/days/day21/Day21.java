package Advent_of_code_2018.days.day21;

import Advent_of_code_2018.days.Day;
import Advent_of_code_2018.days.day19.CPU;

import java.util.HashSet;
import java.util.Set;

public class Day21 implements Day {
    private CPU cpu;

    @Override
    public Object getResultP1(String input) {
        cpu = CPU.loadCPU(input);

        cpu.setDebug(false);
        cpu.setBreakPoint(28);

        int[] registers = cpu.run();
        return registers[5];
    }

    @Override
    public Object getResultP2(String input) {
        cpu = CPU.loadCPU(input);

        cpu.setDebug(false);
        cpu.setBreakPoint(28);

        Set<Integer> numbers = new HashSet<>();
        int previous = -1;
        while (true) {
            int value = cpu.run()[5];
            if (!numbers.add(value)) {
                return previous;
            }
            previous = value;
        }
    }

    @Override
    public int getDay() {
        return 21;
    }
}
