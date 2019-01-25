package Advent_of_code_2018.days.day23;

import Advent_of_code_2018.days.day22.Pos3D;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NanoBot {
    private final Pos3D pos;
    private final int radius;
    private List<NanoBot> botsInradius;

    public NanoBot(String s) {
        String[] coords = s.substring(5, s.indexOf('>')).split(",");
        String radius = s.substring(s.indexOf(" ")).split("=")[1];
        this.radius = Integer.parseInt(radius);
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);
        int z = Integer.parseInt(coords[2]);

        pos = new Pos3D(x, y , z);
    }

    public int getRadius() {
        return radius;
    }

    public void setBotsInRadius(List<NanoBot> otherBots) {
        botsInradius = otherBots.stream()
                .filter(bot -> !bot.equals(this))
                .filter(bot -> pos.manhattan(bot.pos) <= radius)
                .collect(Collectors.toList());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NanoBot)) return false;
        NanoBot nanoBot = (NanoBot) o;
        return getRadius() == nanoBot.getRadius() &&
                pos.equals(nanoBot.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos, getRadius());
    }

    @Override
    public String toString() {
        return "NanoBot{" +
                pos +
                ", radius=" + radius +
                '}';
    }

    public Pos3D getPos() {
        return pos;
    }

}
