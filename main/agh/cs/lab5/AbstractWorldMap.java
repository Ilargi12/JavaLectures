package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab7.IPositionChangeObserver;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d,Animal> animals = new LinkedHashMap<>();
    protected Map<Vector2d,Grass> weeds = new LinkedHashMap<>();

    protected abstract Vector2d assignLowerLeft();

    protected abstract Vector2d assignUpperRight();

    @Override
    public String toString(){
        MapVisualizer map = new MapVisualizer(this);
        Vector2d lowerLeft  = this.assignLowerLeft();
        Vector2d upperRight = this.assignUpperRight();
        return map.draw(lowerLeft,upperRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return objectAt(position) == null || objectAt(position) instanceof Grass;
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(),animal);
            return true;
        }
        else
            throw new IllegalArgumentException(animal.getPosition().toString() + " is occupied by another animal");
    }

    @Override
    public void run(MoveDirection[] directions) {
        Animal[] tmpAnimals = animals.values().toArray(new Animal[0]);
        for(int i= 0; i < directions.length; i++){
            int index = i%tmpAnimals.length;
            animals.remove(tmpAnimals[index].getPosition());
            tmpAnimals[index].move(directions[i]);
            animals.put(tmpAnimals[index].getPosition(),tmpAnimals[index]);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(animals.containsKey(position))
            return animals.get(position);

        return weeds.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal tmpAnimal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition,tmpAnimal);
    }
}
