package Advent_of_code_2018.days.day20;


import Advent_of_code_2018.days.day19.CPU;
import Advent_of_code_2018.days.day19.Day19;
import Advent_of_code_2018.util.Direction;
import Advent_of_code_2018.util.Pos;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Day20Visual extends PApplet {

    public static void main(String... args) {
        PApplet.main(Day20Visual.class.getName());
    }

    @Override
    public void settings() {

        size(1280, 1024);
//        fullScreen();
    }


    @Override
    public void setup() {
        super.setup();
        for (Pos pos : plan.rooms.keySet()){
            System.out.println("Pos: " + pos);
        }
    }

//    FloorPlan plan = FloorPlan.create("^E(|SEN|(NES|NNESS))E$");//new Day20().getInput1());
//    FloorPlan plan = FloorPlan.create("^ESSWWN(E|NNENN(EESSWNSESSS|WWWSSSSE(SW|NNNE)))$");//new Day20().getInput1());
//    FloorPlan plan = FloorPlan.create("^ESSWWN(E|NNENN(EESS(WNSE|)SSS|WWWSSSSE(SW|NNNE)))$");//new Day20().getInput1());
//    FloorPlan plan = FloorPlan.create("^WSSEESWWWNW(S|NENNEEEENN(ESSSSW(NWSW|SSEN)|WSWWN(E|WWS(E|SS))))$");//new Day20().getInput1());
    FloorPlan plan = FloorPlan.create(new Day20().getInput1());


    int bw = 15;

    @Override
    public void draw() {
        translate(width / 2, height / 2);
        scale(0.6f);

        for (var entry : plan.rooms.entrySet()) {
            drawRoom(entry);
        }
        stroke(0);
        beginShape(LINES);
        vertex(0, 0);
        vertex(bw, bw);
        vertex(bw, 0);
        vertex(0, bw);

    }

    private void drawRoom(Map.Entry<Pos, Room> entry) {
        Pos pos = entry.getKey();

        Room room = entry.getValue();
        strokeWeight(4);
        stroke(0);
        rect(pos.getX() * bw, pos.getY() * bw, bw, bw);
        strokeWeight(5);
        stroke(255);
        if (room.hasDoor(Direction.WEST)) {
            line(pos.getX() * bw, pos.getY() * bw + bw / 4, pos.getX() * bw, pos.getY() * bw + 3 * bw / 4);
        }
        if (room.hasDoor(Direction.EAST)) {
            line(pos.getX() * bw + bw, pos.getY() * bw + bw / 4, pos.getX() * bw + bw, pos.getY() * bw + 3 * bw / 4);
        }
        if (room.hasDoor(Direction.NORTH)) {
            line(pos.getX() * bw + bw / 4, pos.getY() * bw, pos.getX() * bw + 3 * bw / 4, pos.getY() * bw);
        }
        if (room.hasDoor(Direction.SOUTH)) {
            line(pos.getX() * bw + bw / 4, pos.getY() * bw + bw, pos.getX() * bw + 3 * bw / 4, pos.getY() * bw + bw);
        }


    }


    @Override
    public void keyPressed() {
//        if (key == ' ') {
//            ground.addWater();
//        } else if (key == 's') {
//            ypos -= 50;
//        } else if (key == 'w') {
//            ypos += 50;
//        } else if (key == 'p') {
//            System.out.println("nWater: " + ground.countWater());
//        }
    }
}
