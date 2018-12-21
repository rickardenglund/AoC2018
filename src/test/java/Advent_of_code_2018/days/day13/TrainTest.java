package Advent_of_code_2018.days.day13;

import Advent_of_code_2018.util.Direction;
import org.junit.Test;

import static Advent_of_code_2018.util.Direction.*;
import static org.junit.Assert.*;

public class TrainTest {

    @Test
    public void turnTest() {
        Train train = new Train(EAST);
        train.crossingTurn();
        assertEquals(NORTH, train.getDirection());

        train.crossingTurn();
        assertEquals(NORTH, train.getDirection());

        train.crossingTurn();
        assertEquals(EAST, train.getDirection());

        train.crossingTurn();
        assertEquals(NORTH, train.getDirection());

        train.crossingTurn();
        assertEquals(NORTH, train.getDirection());
    }

    @Test
    public void turnTest2() {
        Train train = new Train(SOUTH);
        train.crossingTurn();
        assertEquals(EAST, train.getDirection());
    }
}