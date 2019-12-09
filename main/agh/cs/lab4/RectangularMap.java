
package agh.cs.lab4;

import agh.cs.lab2.*;
import agh.cs.lab5.AbstractWorldMap;

public class RectangularMap  {

    private final Vector2d leftBottom;
    private final Vector2d rightUpper;

    public RectangularMap(int width, int height) {
        this.leftBottom = new Vector2d(0,0);
        this.rightUpper = new Vector2d(width,height);
    }

    /*@Override
    public boolean canMoveTo(Vector2d position) {
        return (super.canMoveTo(position) && position.follows(leftBottom) && position.precedes(rightUpper));
    }*/

    protected Vector2d assignLowerLeft() {
        return leftBottom;
    }

    protected Vector2d assignUpperRight() {
        return rightUpper;
    }
}
