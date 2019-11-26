package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class OptionParserTest {

    @Test
    public void parse() {
        String[] args = {"f","","r","f","r","l"};
        MoveDirection[] tab1 = {MoveDirection.FORWARD,null,MoveDirection.RIGHT,
                MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.LEFT };
        assertArrayEquals(OptionParser.parse(args),tab1);
    }
}