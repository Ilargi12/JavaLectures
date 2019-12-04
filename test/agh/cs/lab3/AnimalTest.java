package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    Animal zwierzak = new Animal();

    @Test
    public void rotation() {
        assertEquals("Direction: Północ; Position: (2, 2)", zwierzak.toLongString());

        zwierzak.move(MoveDirection.LEFT);
        assertEquals("Direction: Zachód; Position: (2, 2)", zwierzak.toLongString());

        zwierzak.move(MoveDirection.RIGHT);
        assertEquals("Direction: Północ; Position: (2, 2)", zwierzak.toLongString());

        zwierzak.move(MoveDirection.BACKWARD);
        assertEquals("Direction: Północ; Position: (2, 1)", zwierzak.toLongString());

        zwierzak.move(MoveDirection.FORWARD);
        assertEquals("Direction: Północ; Position: (2, 2)", zwierzak.toLongString());
    }

    @Test
    public void movement() {
        zwierzak.move(MoveDirection.FORWARD);
        zwierzak.move(MoveDirection.RIGHT);
        zwierzak.move(MoveDirection.FORWARD);
        zwierzak.move(MoveDirection.FORWARD);
        zwierzak.move(MoveDirection.FORWARD);
        zwierzak.move(MoveDirection.FORWARD);
        zwierzak.move(MoveDirection.FORWARD);
        zwierzak.move(MoveDirection.RIGHT);
        zwierzak.move(MoveDirection.LEFT);
        assertEquals("Direction: Wschód; Position: (4, 3)", zwierzak.toLongString());
    }
}