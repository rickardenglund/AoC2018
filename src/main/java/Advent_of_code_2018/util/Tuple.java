package Advent_of_code_2018.util;

public class Tuple {
    private final int maxWidth;
    private final int maxHeight;

    public Tuple(int maxWidth, int maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
}
