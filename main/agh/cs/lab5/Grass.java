package agh.cs.lab5;

import agh.cs.lab2.*;

public class Grass implements IWorldMapElement {
    private Vector2d position;

    public Grass(Vector2d position) {
        this.position = position;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString(){
        return "*";
    }
}
