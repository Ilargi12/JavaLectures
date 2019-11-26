package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.OptionParser;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GrassFieldTest {

    private GrassField garfield;
    private Vector2d position3_4;
    private Vector2d position4_5;
    private Animal animal3_4;
    private Animal animal4_5;

    @Before
    public void beforek(){
        String[] args = {"f","l","r","f"};
        MoveDirection[] directions = OptionParser.parse(args);
        garfield = new GrassField(10);
        position3_4 = new Vector2d(3,4);
        position4_5 = new Vector2d(4,5);
        animal3_4 = new Animal(garfield, position3_4);
        animal4_5 = new Animal(garfield, position4_5);
        garfield.place(animal3_4);
        garfield.place(animal4_5);
        garfield.run(directions);
    }


    @Test
    public void canMoveTo() {
        assertTrue(garfield.canMoveTo(new Vector2d(8,8)));
        assertTrue(garfield.canMoveTo(position3_4));
        assertFalse(garfield.canMoveTo(new Vector2d(3,5)));
        assertFalse(garfield.canMoveTo(new Vector2d(4,5)));
    }

    @Test
    public void place() {
        Animal animal3_5 = new Animal(garfield,new Vector2d(3,5));
        assertFalse(garfield.place(animal3_5));

        Animal animal8_8 = new Animal(garfield,new Vector2d(8,8));
        assertTrue(garfield.place(animal8_8));
    }

    @Test
    public void isOccupied() {
        assertTrue(garfield.isOccupied(animal3_4.getPosition()));
        assertTrue(garfield.isOccupied(animal4_5.getPosition()));
        assertFalse(garfield.isOccupied(position3_4));
        assertTrue(garfield.isOccupied(garfield.weeds.get(0).getPosition()));
    }

    @Test
    public void objectAt() {
        assertEquals(animal3_4, garfield.objectAt(animal3_4.getPosition()));

        Grass exampleGrass = garfield.weeds.get(0);
        assertEquals(exampleGrass,garfield.objectAt(garfield.weeds.get(0).getPosition()));
    }

    @Test
    public void run() {
        assertEquals("E", garfield.objectAt(animal3_4.getPosition()).toString());
        assertEquals("W", garfield.objectAt(animal4_5.getPosition()).toString());
    }
}