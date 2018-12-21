package Advent_of_code_2018.days.day19;

import Advent_of_code_2018.days.day10.Dots;
import Advent_of_code_2018.days.day16.instructions.*;

import java.util.*;
import java.util.stream.Collectors;

public class CPU {
    Map<String, Instruction> instructions = new HashMap<>();
    int ip = 0;
    final int ipRegister;
    int[] registers = new int[6];
    private List<Step> program;
    boolean debug = false;
    private Set<Integer> breakPoints = new TreeSet<>();

    public CPU(int ipRegister) {
        this.ipRegister = ipRegister;
        createInstruction(new Addi());
        createInstruction(new Addr());
        createInstruction(new Mulr());
        createInstruction(new Muli());
        createInstruction(new Banr());
        createInstruction(new Bani());
        createInstruction(new Borr());
        createInstruction(new Bori());
        createInstruction(new Setr());
        createInstruction(new Seti());
        createInstruction(new Gtir());
        createInstruction(new Gtri());
        createInstruction(new Gtrr());
        createInstruction(new Eqir());
        createInstruction(new Eqri());
        createInstruction(new Eqrr());
    }

    private void createInstruction(Instruction instruction) {
        instructions.put(instruction.getClass().getSimpleName().toLowerCase(), instruction);
    }

    private void perform(Step step) { //Instruction instruction, int a, int b, int c) {
        registers[ipRegister] = ip;
        if (debug) {
            System.out.print("ip: " + ip + " " + Arrays.toString(registers));
            System.out.print(step);
        }
//        Instruction instruction = nameinstructions.get(name);

        step.getInst().perform(registers, step.getA(), step.getB(), step.getC());

        ip = registers[ipRegister];
        ip++;
        if (debug) {
            System.out.println(Arrays.toString(registers));
        }
    }

    public void load(List<String[]> program) {
        List<Step> steps =
        program.stream().map(parts -> {
            Instruction inst = instructions.get(parts[0]);
            int a = Integer.parseInt(parts[1]);
            int b = Integer.parseInt(parts[2]);
            int c = Integer.parseInt(parts[3]);
            return new Step(inst, a, b, c);
        }).collect(Collectors.toList());

        this.program = steps;
    }

    public int[] run() {
        while (ipInRange()) {
            step();
            if (breakPoints.contains(ip)) {
                break;
            }
        }
        return registers.clone();
    }

    void step() {
        Step operation = program.get(ip);
        perform(operation);
    }

    boolean ipInRange() {
        return ip >= 0 && ip < program.size();
    }

    public int[] run(int[] initialRegisters) {
        registers = initialRegisters.clone();
        return run();
    }

    public static CPU loadCPU(String input) {
        List<String> lines = input.lines().collect(Collectors.toList());
        CPU cpu = new CPU(Integer.parseInt(lines.get(0).split(" ")[1]));

        List<String[]> program = lines
                .subList(1, lines.size()).stream()
                .map(it -> it.split(" "))
                .collect(Collectors.toList());
        cpu.load(program);
        return cpu;
    }

    public void setDebug(boolean debugMode) {
        debug = debugMode;
    }

    public void setBreakPoint(int instructionNr) {
        breakPoints.add(instructionNr);

    }
}
