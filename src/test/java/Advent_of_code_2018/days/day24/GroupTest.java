package Advent_of_code_2018.days.day24;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroupTest {

    @Test
    public void createGroup() {
        Group group = Group.createGroup("1", "17 units each with 5390 hit points (weak to radiation, bludgeoning) with an attack that does 4507 fire damage at initiative 2");

        assertEquals(group.getUnits(), 17);
        assertEquals(group.getHP(), 5390);
        assertEquals(group.getAP(), 4507);
        assertEquals(group.getAttackType(), "fire");
        assertEquals(group.getInitiative(), 2);

        assertFalse(group.getTraits().isWeakTo("sun"));
        assertTrue(group.getTraits().isWeakTo("radiation"));
    }

}