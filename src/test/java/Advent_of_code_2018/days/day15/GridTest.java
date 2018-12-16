package Advent_of_code_2018.days.day15;

import Advent_of_code_2018.util.Pos;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class GridTest {
    @Test
    public void testGetNeighbours() {
        Grid grid = Grid.createGrid("#########\n" +
                "#.......#\n" +
                "#..GGG..#\n" +
                "#..GEG..#\n" +
                "#G..G...#\n" +
                "#......G#\n" +
                "#.......#\n" +
                "#.......#\n" +
                "#########");

        List<Pos> neighbours = List.of(new Pos(2, 3), new Pos(1, 2), new Pos(3, 2), new Pos(2, 1));
        assertEquals(neighbours, grid.getNeighborPositions(new Pos(2, 2)));

        List<Pos> neighbours2 = List.of(new Pos(0, 3), new Pos(1, 2), new Pos(0, 1));
        assertEquals(neighbours2, grid.getNeighborPositions(new Pos(0, 2)));

        List<Pos> neighbours3 = List.of(new Pos(8, 3), new Pos(7, 2), new Pos(8, 1));
        assertEquals(neighbours3, grid.getNeighborPositions(new Pos(8, 2)));

        List<Pos> neighbours4 = List.of(new Pos(7, 7), new Pos(8, 6));
        assertEquals(neighbours4, grid.getNeighborPositions(new Pos(8, 7)));
    }

    @Test
    public void pathToEnemy() {
        Grid grid = Grid.createGrid("#########\n" +
                "#.......#\n" +
                "#..GGG..#\n" +
                "#..GEG..#\n" +
                "#G..G...#\n" +
                "#......G#\n" +
                "#.......#\n" +
                "#......E#\n" +
                "#########");

        assertEquals(0, grid.getPathToEnemy(new Pos(3, 5)).size());
    }

    @Test
    public void pathToEnemy1step() {
        Grid grid = Grid.createGrid("#########\n" +
                "#.......#\n" +
                "#..GGG..#\n" +
                "#..GEG..#\n" +
                "#G..G...#\n" +
                "#......G#\n" +
                "#.......#\n" +
                "#......E#\n" +
                "#########");

        assertEquals(1, grid.getPathToEnemy(new Pos(7, 1)).size());

    }

    @Test
    public void flow() {
        Grid grid = Grid.createGrid("#########\n" +
                "#.......#\n" +
                "#..GGG..#\n" +
                "#..GEG..#\n" +
                "#G..G...#\n" +
                "#......G#\n" +
                "#.......#\n" +
                "#......E#\n" +
                "#########");

        var path = grid.findPath(new Pos(7, 1), Goblin.class);
        assertEquals(1, path.size());
        assertEquals(new Pos(7, 2), path.get(0));
    }


    @Test
    public void path2() {
        Grid grid = Grid.createGrid("#########\n" +
                "#.......#\n" +
                "#..GGG..#\n" +
                "#..GEG..#\n" +
                "#G..G...#\n" +
                "#......G#\n" +
                "#...#...#\n" +
                "#G..#..E#\n" +
                "#########");

        var path = grid.findPath(new Pos(1, 1), Elf.class);
        assertEquals(9, path.size());
        assertEquals(new Pos(1, 2), path.get(0));
        assertEquals(
                List.of(new Pos(1, 2), new Pos(1, 3), new Pos(2, 3), new Pos(3, 3), new Pos(4, 3), new Pos(5, 3), new Pos(6, 3), new Pos(6, 2), new Pos(7, 2)),
                path);
    }


    @Test
    public void walk() {
        Grid grid = Grid.createGrid(
                "#########\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#.E.#...#\n" +
                        "#...#G..#\n" +
                        "#########");

        String expected =
                "#########\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#.E.....#\n" +
                        "#...#G..#\n" +
                        "#...#...#\n" +
                        "#########\n";
        grid.walk();
        assertEquals(expected, grid.toStringNoStats());
    }

    @Test
    public void walk2() {
        Grid grid = Grid.createGrid(
                "#########\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#..EG...#\n" +
                        "#.......#\n" +
                        "#...#...#\n" +
                        "#...#...#\n" +
                        "#########");

        String expected =
                "#########\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#..EG...#\n" +
                        "#.......#\n" +
                        "#...#...#\n" +
                        "#...#...#\n" +
                        "#########\n";
        grid.walk();
        assertEquals(expected, grid.toStringNoStats());
    }

    @Test
    public void noPath() {
        Grid grid = Grid.createGrid(
                "#########\n" +
                        "#...E...#\n" +
                        "#########\n" +
                        "#...G...#\n" +
                        "#########\n");
        String expected =
                "#########\n" +
                        "#...E...#\n" +
                        "#########\n" +
                        "#...G...#\n" +
                        "#########\n";

        grid.walk();
        assertEquals(expected, grid.toStringNoStats());
    }

    @Test
    public void order() {
        Grid grid = Grid.createGrid(
                "#########\n" +
                        "#...E...#\n" +
                        "#.......#\n" +
                        "#...G...#\n" +
                        "#########\n");
        String expected =
                "#########\n" +
                        "#.......#\n" +
                        "#...E...#\n" +
                        "#...G...#\n" +
                        "#########\n";

        grid.walk();
        assertEquals(expected, grid.toStringNoStats());
    }

    @Test
    public void findPath() {
        Grid grid = Grid.createGrid("#########\n" +
                "#.......#\n" +
                "#.......#\n" +
                "#.......#\n" +
                "#.......#\n" +
                "#.......#\n" +
                "#.E.#...#\n" +
                "#...#G..#\n" +
                "#########");

        var path = grid.findPath(new Pos(2, 2), Goblin.class);

        assertEquals(new Pos(2, 3), path.get(0));
    }

    @Test
    public void findPathUpFirst() {
        Grid grid = Grid.createGrid(
                "#########\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#.......#\n" +
                        "#.E.....#\n" +
                        "#G......#\n" +
                        "#########");

        var path = grid.findPath(new Pos(1, 1), Elf.class);

        assertEquals(new Pos(1, 2), path.get(0));
    }

    @Test
    public void completeMovement() {
        Grid grid = Grid.createGrid("#########\n" +
                "#G..G..G#\n" +
                "#.......#\n" +
                "#.......#\n" +
                "#G..E..G#\n" +
                "#.......#\n" +
                "#.......#\n" +
                "#G..G..G#\n" +
                "#########");

        String step1 = "#########\n" +
                "#.G...G.#\n" +
                "#...G...#\n" +
                "#...E..G#\n" +
                "#.G.....#\n" +
                "#.......#\n" +
                "#G..G..G#\n" +
                "#.......#\n" +
                "#########\n";
        String step2 = "#########\n" +
                "#..G.G..#\n" +
                "#...G...#\n" +
                "#.G.E.G.#\n" +
                "#.......#\n" +
                "#G..G..G#\n" +
                "#.......#\n" +
                "#.......#\n" +
                "#########\n";
        String step3 = "#########\n" +
                "#.......#\n" +
                "#..GGG..#\n" +
                "#..GEG..#\n" +
                "#G..G...#\n" +
                "#......G#\n" +
                "#.......#\n" +
                "#.......#\n" +
                "#########\n";

        grid.walk();
        assertEquals(step1, grid.toStringNoStats());

        grid.walk();
        assertEquals(step2, grid.toStringNoStats());

        grid.walk();
        assertEquals(step3, grid.toStringNoStats());
    }


    @Test
    public void attackTest() {
        Grid grid = Grid.createGrid(
                "#########\n" +
                        "#.......#\n" +
                        "#..GE...#\n" +
                        "#...G...#\n" +
                        "#########\n");


        grid.walk();
        assertEquals(200, grid.healthAt(new Pos(4, 1)));
        assertEquals(197, grid.healthAt(new Pos(3, 2)));
        assertEquals(194, grid.healthAt(new Pos(4, 2)));
    }

    @Test
    public void attackTestKill() {
        Grid grid = Grid.createGrid(
                "#########\n" +
                        "#.......#\n" +
                        "#..GE...#\n" +
                        "#...G...#\n" +
                        "#########\n");

        for (int i = 0; i < 40; i++) {
            grid.walk();
        }
        assertEquals(-1, grid.healthAt(new Pos(4, 2)));
    }


    @Test
    public void p1FullExample() {
        int expected = 27730;

        Grid grid = Grid.createGrid("#######\n" +
                "#.G...#\n" +
                "#...EG#\n" +
                "#.#.#G#\n" +
                "#..G#E#\n" +
                "#.....#\n" +
                "#######");

        String expectedstr =
                "#######   \n" +
                        "#G....#   G(200) \n" +
                        "#.G...#   G(131) \n" +
                        "#.#.#G#   G(59) \n" +
                        "#...#.#   \n" +
                        "#....G#   G(200)\n" +
                        "#######\n";

        String afterTick1 = "#######   \n" +
                "#..G..#   G(200) \n" +
                "#...EG#   E(197), G(197) \n" +
                "#.#G#G#   G(200), G(197) \n" +
                "#...#E#   E(197) \n" +
                "#.....#   \n" +
                "#######   \n";
        grid.walk();

        assertEquals(afterTick1, grid.toString());


        String exp2 =
                "#######   \n" +
                        "#...G.#   G(200) \n" +
                        "#..GEG#   G(200), E(188), G(194) \n" +
                        "#.#.#G#   G(194) \n" +
                        "#...#E#   E(194) \n" +
                        "#.....#   \n" +
                        "#######   \n";
        grid.walk();

        assertEquals(exp2, grid.toString());


        String exp3 = "#######   \n" +
                "#...G.#   G(200) \n" +
                "#..G.G#   G(200), G(131) \n" +
                "#.#.#G#   G(131) \n" +
                "#...#E#   E(131) \n" +
                "#.....#   \n" +
                "#######   \n";

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();


        assertEquals(exp3, grid.toString());

        String exp4 = "#######   \n" +
                "#..G..#   G(200) \n" +
                "#...G.#   G(131) \n" +
                "#.#G#G#   G(200), G(128) \n" +
                "#...#E#   E(128) \n" +
                "#.....#   \n" +
                "#######   \n";

        grid.walk();

        assertEquals(exp4, grid.toString());

        String exp5 = "#######   \n" +
                "#.G...#   G(200) \n" +
                "#..G..#   G(131) \n" +
                "#.#.#G#   G(125) \n" +
                "#..G#E#   G(200), E(125) \n" +
                "#.....#   \n" +
                "#######   \n";

        grid.walk();

        assertEquals(exp5, grid.toString());

        String exp6 = "#######   \n" +
                "#G....#   G(200) \n" +
                "#.G...#   G(131) \n" +
                "#.#.#G#   G(122) \n" +
                "#...#E#   E(122) \n" +
                "#..G..#   G(200) \n" +
                "#######   \n";

        grid.walk();

        assertEquals(exp6, grid.toString());

        String exp7 = "#######   \n" +
                "#G....#   G(200) \n" +
                "#.G...#   G(131) \n" +
                "#.#.#G#   G(119) \n" +
                "#...#E#   E(119) \n" +
                "#...G.#   G(200) \n" +
                "#######   \n";

        grid.walk();

        assertEquals(exp7, grid.toString());

        String exp8 = "#######   \n" +
                "#G....#   G(200) \n" +
                "#.G...#   G(131) \n" +
                "#.#.#G#   G(116) \n" +
                "#...#E#   E(113) \n" +
                "#....G#   G(200) \n" +
                "#######   \n";

        grid.walk();
        assertEquals(exp8, grid.toString());

        grid.walk();
        grid.walk();
        grid.walk();
        grid.walk();
        grid.walk();
        grid.walk();
        grid.walk();
        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();

        grid.walk();


        String exp9 = "#######   \n" +
                "#G....#   G(200) \n" +
                "#.G...#   G(131) \n" +
                "#.#.#G#   G(59) \n" +
                "#...#.#   \n" +
                "#....G#   G(200) \n" +
                "#######   \n";
        assertEquals(exp9, grid.toString());

        assertEquals(590, grid.totalHp());


    }
}