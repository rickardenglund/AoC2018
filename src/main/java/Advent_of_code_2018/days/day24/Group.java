package Advent_of_code_2018.days.day24;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Group {
    private int nUnits;
    private int hitPoints;
    private int attackPower;
    private String attackType;
    private int initiative;
    private Traits traits;
    private final String name;

    private Group(String name) {
        this.name = name;
    }

    public static Group createGroup(String name, String row) {
        Group g = new Group(name);
        Pattern pattern = Pattern.compile("(\\d+) units each with (\\d+) hit points (.*)?with an attack that does (\\d+) (\\w+) damage at initiative (\\d+)");
        Matcher matcher = pattern.matcher(row);

        if(matcher.find()) {
            g.nUnits = Integer.parseInt(matcher.group(1));
            g.hitPoints = Integer.parseInt(matcher.group(2));
            g.traits = Traits.parseTraits(matcher.group(3).trim());
            g.attackPower = Integer.parseInt(matcher.group(4));
            g.attackType = matcher.group(5);
            g.initiative = Integer.parseInt(matcher.group(6));



        } else {
            throw new IllegalStateException("Failed to parse");
        }
        return g;
    }



    @Override
    public String toString() {
        return "Group " + name + "{" +
                "nUnits=" + nUnits +
                ", HP=" + hitPoints +
                ", AP=" + attackPower +
                ", attackType='" + attackType + '\'' +
                ", initiative=" + initiative +
                ", traits=" + traits + '}';
    }

    public int getUnits() {
        return nUnits;
    }

    public int getHP() {
        return hitPoints;
    }

    public Traits getTraits() {
        return traits;
    }

    public int getAP() {
        return attackPower;
    }

    public String getAttackType() {
        return attackType;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getEffectivePower() {
        return Math.max(0,attackPower * nUnits);
    }

    public int potentialDamage(Group otherGroup) {
        if (otherGroup.traits.isImmuneTo(this.attackType)) return 0;

        int damage = this.getEffectivePower();
        if (otherGroup.traits.isWeakTo(this.attackType)) {
            return 2 * damage;
        } else {
            return damage;
        }
    }

    public void takeDamage(int damage) {
        int nDead = damage / hitPoints;
        nUnits -= nDead;
    }

    public void increaseAp(int boost) {
        attackPower += boost;
    }
}
