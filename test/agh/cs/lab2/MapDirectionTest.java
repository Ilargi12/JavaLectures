package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapDirectionTest {

    @Test
    public void tostring() {
        assertEquals("Północ", MapDirection.NORTH.toString());
        assertEquals("Południe", MapDirection.SOUTH.toString());
        assertEquals("Wschód", MapDirection.EAST.toString());
        assertEquals("Zachód", MapDirection.WEST.toString());
    }

    @Test
    public void next() {
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
    }

    @Test
    public void previous() {
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
    }

    @Test
    public void toUnitVector() {
        assertEquals(new Vector2d(0,1), MapDirection.NORTH.toUnitVector());
        assertEquals(new Vector2d(0,-1), MapDirection.SOUTH.toUnitVector());
        assertEquals(new Vector2d(1,0), MapDirection.EAST.toUnitVector());
        assertEquals(new Vector2d(-1,0), MapDirection.WEST.toUnitVector());
    }
}