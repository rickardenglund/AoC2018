package Advent_of_code_2018.days.day15;

public abstract class Warrior extends Entity {

    int tickModifed = -1;
    private int Hp = 200;

    public void setUpdate(int tick) {
        tickModifed = tick;
    }

    public int getlastModified() {
        return  tickModifed;
    }

    public int getHealth() {
        return Hp;
    }

    public void takeDamage(int n) {
        Hp -= n;
    }

    public boolean isAlive() {
        return Hp > 0;
    }

    abstract public int getAttackPower();
}
