package Advent_of_code_2018.days.day15;

import org.junit.Test;

import static org.junit.Assert.*;

public class EntityTest {

    @Test
    public void isEnemy() {
        assertFalse(new Goblin().isEnemy(new Space()));
        assertFalse(new Goblin().isEnemy(new Goblin()));

        assertTrue(new Goblin().isEnemy(new Elf()));
        assertTrue(new Elf().isEnemy(new Goblin()));

    }

}