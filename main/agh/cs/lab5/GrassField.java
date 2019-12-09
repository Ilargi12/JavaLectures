package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab7.MapBoundary;

import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private Vector2d lowerLeft = null;
    private Vector2d upperRight = null;
    private Integer numberOfFields;



    public GrassField(Integer numberOfFields) {
        this.numberOfFields = numberOfFields;

        for(int i = 0; i<numberOfFields;i++){
            placeGrass();
        }
    }

    private void placeGrass()
    {
        int roundSqrt = (int)sqrt(10*this.numberOfFields);
        while (true) {
            int x = new Random().nextInt(roundSqrt + 1);
            int y = new Random().nextInt(roundSqrt + 1);
            Vector2d field = new Vector2d(x, y);

            if(!isOccupied(field)){
                Grass brandNewGrass = new Grass(field);
                weeds.put(brandNewGrass.getPosition(),brandNewGrass);
                boundries.addToSet(brandNewGrass.getPosition());
                return;
            }
        }

    }

    /*@Override
    protected Vector2d assignLowerLeft() {
        for (Map.Entry<Vector2d,Animal> entry: animals.entrySet()){
            lowerLeft = entry.getValue().getPosition().lowerLeft(lowerLeft);
        }
        for (Map.Entry<Vector2d,Grass> entry: weeds.entrySet()){
            lowerLeft = entry.getValue().getPosition().lowerLeft(lowerLeft);
        }
        return lowerLeft;
    }*/

    @Override
    protected Vector2d assignLowerLeft() {
        return boundries.bottomLeft();
    }

    /*@Override
    protected Vector2d assignUpperRight() {
        for (Map.Entry<Vector2d,Animal> entry: animals.entrySet()){
            upperRight = entry.getValue().getPosition().upperRight(upperRight);
        }
        for (Map.Entry<Vector2d,Grass> entry: weeds.entrySet()){
            upperRight = entry.getValue().getPosition().upperRight(upperRight);
        }
        return upperRight;
    }*/

    @Override
    protected Vector2d assignUpperRight(){
        return boundries.upperRight();
    }

    /*@Override
    public void run(MoveDirection[] directions) {
        Animal[] tmpAnimals = animals.values().toArray(new Animal[0]);
        for(int i= 0; i < directions.length; i++){
            int index = i%tmpAnimals.length;
            animals.remove(tmpAnimals[index].getPosition());
            tmpAnimals[index].move(directions[i]);
            animals.put(tmpAnimals[index].getPosition(),tmpAnimals[index]);

            Vector2d cowPosition = tmpAnimals[index].getPosition();

            if(getThatGrass(cowPosition) != null){
                weeds.remove(getThatGrass(cowPosition).getPosition());
                placeGrass();
            }
        }
    }*/

    @Override
    public void run(MoveDirection[] directions) {
        Animal[] tmpAnimals = animals.values().toArray(new Animal[0]);
        for(int i= 0; i < directions.length; i++){
            int index = i%tmpAnimals.length;
            tmpAnimals[index].move(directions[i]);
        }
    }

    private Grass getThatGrass(Vector2d position){
        return weeds.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){ //positionChanged with eating grass
        Animal zwierzak = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition,zwierzak);

        if(getThatGrass(newPosition) != null) {//eating grass
            weeds.remove(getThatGrass(newPosition).getPosition());
            boundries.removeFromSet(newPosition);
            placeGrass();
        }
    }
}