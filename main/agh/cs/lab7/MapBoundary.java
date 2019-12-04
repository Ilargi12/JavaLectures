package agh.cs.lab7;

import agh.cs.lab2.Vector2d;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {

    SortedSet<Vector2d> xSet = new TreeSet<>( (a,b) -> {
        if (a.x != b.x) return a.x - b.x;
        return a.y - b.y;
    });

    SortedSet<Vector2d> ySet = new TreeSet<>( (a,b) -> {
        if (a.y != b.y) return a.y - b.y;
        return a.x - b.x;
    });

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(!oldPosition.equals(newPosition)) {
            xSet.remove(oldPosition);
            xSet.add(newPosition);
            ySet.remove(oldPosition);
            ySet.add(newPosition);
        }
    }

    public void addToSet(Vector2d newPosition){
        xSet.add(newPosition);
        ySet.add(newPosition);
    }

    public void removeFromSet(Vector2d position){
        xSet.remove(position);
        ySet.remove(position);
    }

    public Vector2d bottomLeft(){
        if (xSet.isEmpty() )
            return new Vector2d(0,0);

        return new Vector2d(xSet.first().x , ySet.first().y);
    }

    public Vector2d upperRight(){
        if (xSet.isEmpty() )
            return new Vector2d(0,0);

        return new Vector2d(xSet.last().x, ySet.last().y);
    }
}
