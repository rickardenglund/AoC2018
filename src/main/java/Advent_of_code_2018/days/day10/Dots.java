package Advent_of_code_2018.days.day10;

import Advent_of_code_2018.util.Pos;
import Advent_of_code_2018.util.Tuple;

import java.util.ArrayList;
import java.util.List;

public class Dots {
    List<Dot> dots = new ArrayList<>();

    public void add(String s) {
        var filtered = s.replaceAll("[a-zA-Z=<>,]", "").trim();
        var parts = filtered.split("\\s+");
        var dot = new Dot(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim()), Integer.parseInt(parts[2].trim()), Integer.parseInt(parts[3].trim()));
        dots.add(dot);
    }

    public List<Pos> getDots(int time) {
        var list = new ArrayList<Pos>();
        for (var dot: dots) {
            list.add(dot.getPos(time));
        }
        return list;
    }

    public Tuple<Integer, Integer> average(int time) {
        int avgX = (int) Math.floor(dots.stream().mapToInt(it -> it.getPos(time).getX()).average().getAsDouble());
        int avgY = (int) Math.floor(dots.stream().mapToInt(it -> it.getPos(time).getY()).average().getAsDouble());
        return new Tuple<>(avgX, avgY);

    }
}
