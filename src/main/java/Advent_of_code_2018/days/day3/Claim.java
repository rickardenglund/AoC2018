package Advent_of_code_2018.days.day3;

public class Claim {
    private int id;
    private final int xpos;
    private final int ypos;
    private final int width;
    private final int height;
    private boolean broken = false;

    public Claim(String description) {
        String[] parts = description.split(" ");
        id = Integer.parseInt(parts[0].substring(1));
        xpos = Integer.parseInt(parts[2].split(",")[0]);
        String yPosStr = parts[2].split(",")[1];
        ypos = Integer.parseInt(yPosStr.substring(0, yPosStr.length() - 1));
        width = Integer.parseInt(parts[3].split("x")[0]);
        height = Integer.parseInt(parts[3].split("x")[1]);
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

}
