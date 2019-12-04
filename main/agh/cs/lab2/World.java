package agh.cs.lab2;

import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import agh.cs.lab5.GrassField;

public class World {
    public static void main(String[] args){
        MoveDirection[] directions = OptionParser.parse(args);
        GrassField map = new GrassField(10);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        System.out.println(map.toString());
    }
}
