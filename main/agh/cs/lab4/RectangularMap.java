
package agh.cs.lab4;

import agh.cs.lab2.*;
import agh.cs.lab3.*;
import agh.cs.lab5.AbstractWorldMap;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    private final Vector2d leftBottom;
    private final Vector2d rightUpper;

    public RectangularMap(int width, int height) {
        this.leftBottom = new Vector2d(0,0);
        this.rightUpper = new Vector2d(width,height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (super.canMoveTo(position) && position.follows(leftBottom) && position.precedes(rightUpper));
    }

    @Override
    protected Vector2d assignLowerLeft() {
        return leftBottom;
    }

    @Override
    protected Vector2d assignUpperRight() {
        return rightUpper;
    }
}
