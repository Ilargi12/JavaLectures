/*
package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.OptionParser;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.*;

public class RectangularMapTest {
    Vector2d v3_3 = new Vector2d(3,3);
    Vector2d v6_6 = new Vector2d(6,6);
    Vector2d v5_5 = new Vector2d(5,5);
    IWorldMap mapa = new RectangularMap(5,5);
    List<Animal> animals = new ArrayList<>();
    Animal zwierzak3_3 = new Animal(mapa,v3_3);
    Animal zwierzak6_6 = new Animal(mapa,v6_6);
    Animal zwierzak5_5 = new Animal(mapa,v5_5);

    @Test
    public void canMoveTo() {
        assertTrue(mapa.canMoveTo(v3_3));
        assertFalse(mapa.canMoveTo(v6_6));
    }

    @Test
    public void shouldBeAbleToAddToPlace() {
        mapa.place(zwierzak3_3);
        assertFalse(mapa.place(zwierzak3_3));

        assertFalse(mapa.place(zwierzak6_6));
    }

    @Test
    public void isOccupied() {
        assertFalse(mapa.isOccupied(v3_3));
        mapa.place(zwierzak3_3);
        assertTrue(mapa.isOccupied(v3_3));
    }

    @Test
    public void objectAt() {
        mapa.place(zwierzak3_3);
        assertEquals(zwierzak3_3, mapa.objectAt(v3_3));
        assertEquals(null, mapa.objectAt(new Vector2d(4, 5)));

    }

    @Test
    //@ParametrizedTest
    //@Value/EnumSource
    public void shouldNotMoveToSameField(){
        String[] moves = {"f","b","r","r","f","f"};
        MoveDirection[] directions = OptionParser.parse(moves);
        mapa.place(zwierzak3_3);
        mapa.place(zwierzak5_5);
        mapa.run(directions);
        assertEquals(new Vector2d(4,4),zwierzak3_3.getPosition());
        assertEquals(new Vector2d(5,4),zwierzak5_5.getPosition());
    }
}*/
