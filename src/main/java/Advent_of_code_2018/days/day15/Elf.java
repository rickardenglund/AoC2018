package Advent_of_code_2018.days.day15;

public class Elf extends Warrior {
    public static int ELF_POWER = 3;
    @Override
    public String toString() {
        return "E";
    }

    @Override
    public boolean isEnemy(Entity other) {
        return other instanceof Goblin;
    }

    @Override
    public int getAttackPower() {
        return ELF_POWER;
    }
}
