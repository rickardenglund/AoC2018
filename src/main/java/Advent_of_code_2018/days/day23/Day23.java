package Advent_of_code_2018.days.day23;

import Advent_of_code_2018.days.Day;
import Advent_of_code_2018.days.day22.Pos3D;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day23 implements Day {
    @Override
    public Object getResultP1(String input) {
        List<NanoBot> bots = readNanoBots(input);

        NanoBot biggestRadius = bots.stream().max(Comparator.comparingInt(bot -> bot.getRadius())).get();

        long count = bots.stream()
                .filter(other -> other.getPos().manhattan(biggestRadius.getPos()) <= biggestRadius.getRadius())
                .count();

        return count;
    }

    private List<NanoBot> readNanoBots(String input) {
        return Arrays.stream(input.split("\n"))
                .map(NanoBot::new)
                .collect(Collectors.toList());
    }

    @Override
    public Object getResultP2(String input) {
        List<NanoBot> bots = readNanoBots(input);

        bots.forEach(bot -> bot.setBotsInRadius(bots));

        Pos3D pos = findBestPos(bots);


        return new Pos3D(0,0,0).manhattan(pos);
    }

    private Pos3D findBestPos(List<NanoBot> bots) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int minZ = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int maxZ = Integer.MIN_VALUE;

        for (NanoBot b : bots) {
            minX = Math.min(minX, b.getPos().getX());
            minY = Math.min(minY, b.getPos().getY());
            minZ = Math.min(minZ, b.getPos().getDepth());
            maxX = Math.max(maxX, b.getPos().getX());
            maxY = Math.max(maxY, b.getPos().getY());
            maxZ = Math.max(maxZ, b.getPos().getDepth());
        }


        Pos3D bestPos = null;
        long bestMax = - 1;
        for (int x = minX; x < maxX; x++) {
            for (int y = minY; y < maxY; y++) {
                for (int z = minZ; z < maxZ; z++) {
                    Pos3D pos = new Pos3D(x, y, z);
                    long botsInRange = botsInRangeOf(bots, pos);
                    if (botsInRange > bestMax) {
                        bestPos = pos;
                        bestMax = botsInRange;
                        System.out.println(bestPos + " " +"n: " + bestMax + " dist: " + new Pos3D(0,0,0).manhattan(bestPos));
                    }
                }
            }
        }


        return bestPos;
    }

    private long botsInRangeOf(List<NanoBot> bots, Pos3D pos) {
        return bots.stream()
                .filter(b -> b.getPos().manhattan(pos) <= b.getRadius())
                .count();
    }

    @Override
    public int getDay() {
        return 23;
    }
}
