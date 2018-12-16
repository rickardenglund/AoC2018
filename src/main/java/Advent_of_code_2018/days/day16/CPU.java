package Advent_of_code_2018.days.day16;

import Advent_of_code_2018.days.day16.instructions.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CPU {
    List<Instruction> instructions = new ArrayList<>();
    Map<Instruction, List<Integer>> tmpOpCodeMap = new HashMap<>();

    public CPU() {
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
        instructions.add(instruction);
        tmpOpCodeMap.put(instruction, allPossbileOpcodes());
    }

    private List<Integer> allPossbileOpcodes() {
        return IntStream.range(0, 16)
                .mapToObj(it -> it)
                .collect(Collectors.toList());
    }

    public List<Instruction> getPossibleInstructions(String input) {
        TestData data = new TestData(input);
        return getPossibleInstructions(data);
    }

    public List<Instruction> getPossibleInstructions(TestData data) {
        List<Instruction> possibleInstructions = instructions.stream()
                .filter(instruction -> instruction.matches(data))
                .collect(Collectors.toList());
        Integer opCode = data.instruction[0];

        for (var entry : tmpOpCodeMap.entrySet()) {
            if (!possibleInstructions.contains(entry.getKey())) {
                entry.getValue().remove(opCode);
            }
        }

        cleanCodes();

        return possibleInstructions;
    }


    Map<Integer, Instruction> opCodeMap = new HashMap<>();

    public void printOpCodes() {
        tmpOpCodeMap.forEach((inst, codes) -> System.out.println(inst.getClass().getSimpleName() + ": " + codes));
        opCodeMap.forEach((code, instr) -> System.out.println(instr.getClass().getSimpleName() + ": " + code));
    }


    private void cleanCodes() {
        boolean changes = true;
        while (changes) {
            changes = false;

            List<Integer> singles = new ArrayList<>();
            List<Instruction> toRemove = new ArrayList<>();

            for (Map.Entry<Instruction, List<Integer>> entry : tmpOpCodeMap.entrySet()) {
                Instruction instr = entry.getKey();
                List<Integer> opcodes = entry.getValue();
                if (opcodes.size() == 1) {
                    changes = true;
                    singles.add(opcodes.get(0));
                    toRemove.add(instr);
                    opCodeMap.put(opcodes.get(0), instr);
                }
            }

            for (var instr: toRemove) {
                tmpOpCodeMap.remove(instr);
            }

            for (var single: singles) {
                for (Map.Entry<Instruction, List<Integer>> entry : tmpOpCodeMap.entrySet()) {
                    entry.getValue().remove(single);
                }
            }

        }
    }

    int[] registers = new int[4];
    public void execute(String it) {
        Integer[] parts = Arrays.stream(it.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Instruction instr = opCodeMap.get(parts[0]);
        instr.perform(registers, parts[1], parts[2], parts[3]);

    }

    public Object getReg(int i) {
        return registers[i];
    }
}
