package Advent_of_code_2018.days.day3;

public class Claim {
    private int id;
    private final int xpos;
    private final int ypos;
    private final int width;
    private final int height;
    private boolean broken = false;

    public Claim(int id, int xpos, int ypos, int width, int height) {
        this.id = id;
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "xpos=" + xpos +
                ", ypos=" + ypos +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public void setBroken() {
        broken = true;
    }

    public boolean isBroken() {
        return broken;
    }
}
