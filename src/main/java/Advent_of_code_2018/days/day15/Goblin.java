package Advent_of_code_2018.days.day15;

public class Goblin extends Warrior {
    @Override
    public String toString() {
        return "G";
    }

    @Override
    public boolean isEnemy(Entity other) {
        return other instanceof Elf;
    }

    @Override
    public int getAttackPower() {
        return 3;
    }
}
