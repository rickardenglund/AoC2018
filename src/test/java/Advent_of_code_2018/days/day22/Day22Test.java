package Advent_of_code_2018.days.day22;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day22Test {

    @Test
    public void p1() {
        int expected = 114;
        String input = "depth: 510\n" +
                "target: 10,10";
        var sut = new Day22();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p1String() {
        String expected =
                ".=.|=.|.|=.\n" +
                ".|=|=|||..|\n" +
                ".==|....||=\n" +
                "=.|....|.==\n" +
                "=|..==...=.\n" +
                "=||.=.=||=|\n" +
                "|.=.===|||.\n" +
                "|..==||=.|=\n" +
                ".=..===..=|\n" +
                ".======|||=\n" +
                ".===|=|===.\n";
        var sut = new Day22();
        assertEquals(expected, sut.toString(new Pos3D(10, 10, 510)));
    }

    @Test
    public void p1String2() {
        String expected =
                ".=.|=.|.|=.\n" +
                        ".|=|=|||..|\n" +
                        ".==|....||=\n" +
                        "=.|....|.==\n" +
                        "=|..==...=.\n" +
                        "=||.=.=||=|\n" +
                        "|.=.===|||.\n" +
                        "|..==||=.|=\n" +
                        ".=..===..=|\n" +
                        ".======|||=\n" +
                        ".===|=|===.\n";
        var sut = new Day22();
        assertEquals(expected, sut.toString(new Pos3D(10, 10, 510)));
    }

    @Test
    public void p1Real() {
        int expected = 10395;
        var sut = new Day22();
        String input = sut.getInput1();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Test
    public void p2() {
        int expected = 45;
        String input = "depth: 510\n" +
                "target: 10,10";
        var sut = new Day22();
        assertEquals(expected, sut.getResultP2(input));
    }



    @Test
    public void geoIndex() {
        var sut = new Day22();
        var depth = 510;
        var target = new Pos3D(10, 10, depth);
        assertEquals(510, sut.calculateGeologicalLevel(new Pos3D(0,0, depth), target));
        assertEquals(8415, sut.calculateGeologicalLevel(new Pos3D(0,1, depth), target));
        assertEquals(17317, sut.calculateGeologicalLevel(new Pos3D(1,0, depth), target));
        assertEquals(1805, sut.calculateGeologicalLevel(new Pos3D(1,1, depth), target));
    }
}