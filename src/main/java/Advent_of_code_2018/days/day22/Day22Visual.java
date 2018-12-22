package Advent_of_code_2018.days.day22;


import Advent_of_code_2018.days.day20.Room;
import Advent_of_code_2018.util.Direction;
import Advent_of_code_2018.util.Pos;
import processing.core.PApplet;

import java.util.Map;

public class Day22Visual extends PApplet {

    public static void main(String... args) {
        PApplet.main(Day22Visual.class.getName());
    }

    @Override
    public void settings() {

        size(1280, 1024);
    }


    Day22 sut = new Day22();
    @Override
    public void setup() {
        super.setup();

    }



    int bw = 15;

    @Override
    public void draw() {
        translate(width / 2, height / 2);

        Pos3D target = new Pos3D(10, 10, 510);
        for (int y = 0; y <= target.y; y++) {
            for (int x = 0; x <= target.x; x++) {
                Pos3D pos = new Pos3D(x, y, target.depth);
                int groundType = sut.getGroundType(pos, target);
                rect(x * bw, y * bw, bw, bw);
            }
        }

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
