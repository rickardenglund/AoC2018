package Advent_of_code_2018.days.day19;


import Advent_of_code_2018.days.day17.Day17;
import Advent_of_code_2018.days.day17.Ground;
import Advent_of_code_2018.util.Pos;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Day19Visual extends PApplet {

    private CPU cpu;

    @Override
    public void settings() {

//        size(1280, 1024);
        fullScreen();
    }


    @Override
    public void setup() {
        super.setup();
        cpu = CPU.loadCPU(new Day19().getInput1());
        cpu.registers = new int[] {0, 0, 0, 0, 0, 0};
    }


    List<Pos> ipPoss = new ArrayList<>();
    int tick = 0;
    int bw = 40;

    @Override
    public void draw() {
//        System.out.println(ipPoss);
        background(255);
        if (cpu.ipInRange()) {
            cpu.step();
        } else {
            System.out.println("Done");
        }
        ipPoss.add(new Pos(tick, cpu.ip));

        beginShape();
        for (var pos : ipPoss) {
            vertex(pos.getX(), pos.getY() * bw);
        }
        endShape();


        tick++;
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

    public static void main(String... args) {
        PApplet.main(Day19Visual.class.getName());
    }
}
