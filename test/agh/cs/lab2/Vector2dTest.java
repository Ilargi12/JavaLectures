package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2dTest {

    Vector2d helper1 = new Vector2d(1,1);
    Vector2d helper2 = new Vector2d(2,2);

    @Test
    public void testToString() {
        assertEquals("(1, 1)", helper1.toString());
    }

    @Test
    public void precedes() {
        assertTrue(helper1.precedes(helper2));
        assertFalse(helper2.precedes(helper1));
    }

    @Test
    public void follows() {
        assertTrue(helper2.follows(helper1));
        assertFalse(helper1.follows(helper2));
    }

    @Test
    public void upperRight() {
        assertEquals(helper2, helper1.upperRight(helper2));
    }

    @Test
    public void lowerLeft() {
        assertEquals(helper1, helper1.lowerLeft(helper2));
    }

    @Test
    public void add() {
        assertEquals(new Vector2d(3,3), helper1.add(helper2));
    }

    @Test
    public void subtract() {
        assertEquals(new Vector2d(-1,-1), helper1.substract(helper2));
    }

    @Test
    public void testEquals() {
        assertEquals(helper1, new Vector2d(1, 1));
        assertNotEquals(helper1, helper2);
        assertNotEquals(null, helper1);
    }

    @Test
    public void opposite() {
        assertEquals(new Vector2d(-1,-1), helper1.opposite());
    }
}