package Advent_of_code_2018.days.day19;

import Advent_of_code_2018.days.day16.instructions.Instruction;

public class Step {
    private final Instruction inst;
    private final int a;
    private final int b;
    private final int c;

    public Step(Instruction inst, int a, int b, int c) {

        this.inst = inst;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Instruction getInst() {
        return inst;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public String toString() {
        return String.format(" %s %d %d %d ", inst.getClass().getSimpleName(), a, b, c);
    }
}
