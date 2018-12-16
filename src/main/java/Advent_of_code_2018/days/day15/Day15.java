package Advent_of_code_2018.days.day15;

import Advent_of_code_2018.days.Day;

public class Day15 implements Day {
    public Grid gridp1;

    @Override
    public Object getResultP1(String input) {
        Grid grid = Grid.createGrid(input);

        while (grid.moreFighting()) {
            grid.walk();
        }

        var totalHp = grid.totalHp();
        System.out.println(grid);
        System.out.println("i: " + grid.getTick());
        System.out.println(totalHp);
        gridp1 = grid;
        return (grid.getTick() - 1) * totalHp;
    }

    @Override
    public Object getResultP2(String input) {
        Grid grid;
        do {
            Elf.ELF_POWER++;
            grid = Grid.createGrid(input);
            while (grid.moreFighting()) {
                grid.walk();
            }
        } while (grid.getDeadElves() > 0);

        System.out.println("Elf power: " + Elf.ELF_POWER);
        var totalHp = grid.totalHp();
        return (grid.getTick() - 1) * totalHp;
    }

    @Override
    public int getDay() {
        return 15;
    }
}
