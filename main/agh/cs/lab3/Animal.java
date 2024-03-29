package agh.cs.lab3;

import agh.cs.lab2.*;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.IWorldMapElement;
import agh.cs.lab7.IPositionChangeObserver;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IWorldMapElement {
    private MapDirection direction;
    private Vector2d position;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();


    public Animal(){
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map){
        this();
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.direction = MapDirection.NORTH;
        this.map = map;
        this.position = initialPosition;
    }

    public MapDirection getDirection() {
        return direction;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString(){
        switch (this.direction){
            case NORTH:
                return "N";
            case EAST:
                return "E";
            case SOUTH:
                return "S";
            case WEST:
                return "W";
            default:
                return null;
        }
    }

    public String toLongString(){
        return String.format("Direction: %s; Position: %s", direction.toString(), position.toString() );
    }

    public void move(MoveDirection kierunekRuchu){
        Vector2d wersor = this.direction.toUnitVector();

        switch (kierunekRuchu){
            case LEFT:
                direction = direction.previous();
                break;
            case RIGHT:
                direction = direction.next();
                break;
            case FORWARD:
                if(map.canMoveTo(this.position.add(wersor))){
                    Vector2d oldPosition = this.position;
                    this.position = this.position.add(wersor);
                    this.notifyObserversThatPositionChanged(oldPosition,this.position);
                }
                break;
            case BACKWARD:
                if (map.canMoveTo(this.position.substract(wersor))){
                    Vector2d oldPosition = this.position;
                    this.position = this.position.substract(wersor);
                    this.notifyObserversThatPositionChanged(oldPosition,this.position);
                }
                break;
            default:
                break;
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    void notifyObserversThatPositionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver x: observers){
            x.positionChanged(oldPosition,newPosition);
        }
    }
}
