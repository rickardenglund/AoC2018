package Advent_of_code_2018.days.day5;

import org.checkerframework.checker.units.qual.C;

public class Part {
    private final boolean upper;
    private int type;
    public Part(String type) {
        this.type = Character.getNumericValue(Character.toLowerCase(type.charAt(0)));
        this.upper = Character.isUpperCase(type.charAt(0));
    }

    public boolean isUpper() {
        return upper;
    }

    public int getType() {
        return type;
    }

    public boolean reactsWith(Part second) {
        return getType() == second.getType() && isUpper() != second.isUpper();
    }

    @Override
    public String toString() {
        if (isUpper()) {
            return "" + Character.toUpperCase(Character.forDigit(getType(), 36));
        }
        else {
            return "" + Character.forDigit(getType(), 36);
        }
    }
}
