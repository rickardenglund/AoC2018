package Advent_of_code_2018.days.day13;

import Advent_of_code_2018.util.Pos;
import processing.core.PApplet;

import java.util.List;

public class Day13Visual extends PApplet {

    Grid grid;

    @Override
    public void settings() {
        size(1280, 1024);
    }

    @Override
    public void setup() {
        super.setup();
        String[] lines = input.split("\n");
        grid = Day13.createGrid(lines);
        Day13.populateGrid(grid, lines);
    }

    @Override
    public void draw() {
        background(200, 200, 200);
        draw(grid);
    }

    int boxWidth = 10;
    int spacing = 5;
    private void draw(Grid gridObject) {
        Track[][] grid = gridObject.getGrid();
        for (int y = 0; y < gridObject.getHeight(); y++) {
            for (int x = 0; x < gridObject.getWidth(); x++) {
                int midX = (x + 1)*boxWidth + spacing*x;
                int midY = (y + 1)*boxWidth + spacing * y;


                stroke(20, 20, 20);
                strokeWeight(3);
                grid[x][y].exits.forEach((it) -> {
                    switch (it) {
                        case NORTH:
                            line(midX, midY, midX, midY - boxWidth/2);
                            break;
                        case EAST:
                            line(midX, midY, midX + boxWidth/2, midY);
                            break;
                        case SOUTH:
                            line(midX, midY, midX, midY + boxWidth/2);
                            break;
                        case WEST:
                            line(midX, midY, midX - boxWidth/2, midY);
                            break;
                    }
                });


                stroke(20, 20, 200);
                strokeWeight(5);
                if (grid[x][y].train.isPresent()) {
                    switch (grid[x][y].train.get().getDirection()) {
                        case NORTH:
                            line(midX-boxWidth/2, midY, midX, midY - boxWidth/2);
                            line(midX+boxWidth/2, midY, midX, midY - boxWidth/2);
                            break;
                        case EAST:
                            line(midX+boxWidth/2, midY, midX, midY + boxWidth/2);
                            line(midX+boxWidth/2, midY, midX, midY - boxWidth/2);
                            break;
                        case SOUTH:
                            line(midX-boxWidth/2, midY, midX, midY + boxWidth/2);
                            line(midX+boxWidth/2, midY, midX, midY + boxWidth/2);
                            break;
                        case WEST:
                            line(midX-boxWidth/2, midY, midX, midY + boxWidth/2);
                            line(midX-boxWidth/2, midY, midX, midY - boxWidth/2);
                            break;
                    }
                }
            }

        }
    }


    int tick = 0;
    @Override
    public void keyPressed() {
        if (key == ' ') {
            System.out.println("Tick: " + tick);
            grid.tick(tick++);
            System.out.println(grid);

        }
    }

    public static void main(String... args) {
        PApplet.main(Day13Visual.class.getName());
    }

    String input = "/>-<\\  \n" +
            "|   |  \n" +
            "| /<+-\\\n" +
            "| | | v\n" +
            "\\>+</ |\n" +
            "  |   ^\n" +
            "  \\<->/";
}
