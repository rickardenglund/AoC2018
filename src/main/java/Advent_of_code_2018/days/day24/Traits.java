package Advent_of_code_2018.days.day24;

import java.util.ArrayList;
import java.util.List;

public class Traits {
    private final List<String> immunities = new ArrayList<>();
    private final List<String> weaknesses = new ArrayList<>();

    public static Traits parseTraits(String str) {
        if (str.length() > 2) {
            str = str.substring(1, str.length() - 1); // remove parenthesis
        }
        Traits traits = new Traits();
        for (String part : str.split(";")) {
            part = part.trim();
            if (part.startsWith("immune to")) {
                String immunityString = part.substring(9);
                for (String immunity : immunityString.split(",")) {
                    traits.immunities.add(immunity.trim());
                }
            } else if (part.startsWith("weak to")) {
                String weaknessString = part.substring(7);
                for (String weakness : weaknessString.split(",")) {
                    traits.weaknesses.add(weakness.trim());
                }
            }
        }

        return traits;
    }

    public boolean isImmuneTo(String immunity) {
        return immunities.contains(immunity);
    }

    public boolean isWeakTo(String weakness) {
        return weaknesses.contains(weakness);
    }

    @Override
    public String toString() {
        return "Traits{" +
                "immunities=" + immunities +
                ", weaknesses=" + weaknesses +
                '}';
    }
}
