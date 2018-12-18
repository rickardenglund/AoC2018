package Advent_of_code_2018.days.day17;


import processing.core.PApplet;

public class Day17Visual extends PApplet {
    private float ypos = 0;

    @Override
    public void settings() {

//        size(1280, 1024);
        fullScreen();
    }

    String input = "x=495, y=2..7\n" +
            "y=7, x=495..501\n" +
            "x=501, y=3..7\n" +
            "x=498, y=2..4\n" +
            "x=506, y=1..2\n" +
            "x=498, y=10..13\n" +
            "x=504, y=10..13\n" +
            "y=13, x=498..504";

    @Override
    public void setup() {
        super.setup();
        ground = new Ground();
        ground.create(new Day17().getInput1());
//        ground.create(input);
    }

    Ground ground;

    @Override
    public void draw() {
        background(200, 200, 200);
        translate(0, ypos);
        draw(ground);
    }

    int boxWidth = 10;
    int spacing = 1;

    private void draw(Ground ground) {
        Character[][] map = ground.getMap();

        for (int y = 0; y < ground.getHeight(); y++) {
            for (int x = 0; x < ground.getWidth(); x++) {

                setColor(map[x][y]);
                strokeWeight(0);
                rect(x * boxWidth + x * spacing, y * boxWidth + y * spacing, boxWidth, boxWidth);
            }
        }

    }

    private void setColor(Character character) {
        switch (character) {
            case '.':
                fill(200, 200, 200);
                break;
            case '#':
                fill(0);
                break;
            case '|':
                fill(100, 150, 200);
                break;
            case '~':
                fill(150, 50, 200);
                break;
            default:
                System.out.println("Unknown : " + character);
        }
    }


    int tick = 0;

    @Override
    public void keyPressed() {
        if (key == ' ') {
            ground.addWater();
        } else if (key == 's') {
            ypos -= 50;
        } else if (key == 'w') {
            ypos += 50;
        } else if (key == 'p') {
            System.out.println("nWater: " + ground.countWater());
        }
    }

    public static void main(String... args) {
        PApplet.main(Day17Visual.class.getName());
    }
}
