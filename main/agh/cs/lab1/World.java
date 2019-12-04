package agh.cs.lab1;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.OptionParser;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab5.GrassField;

public class World {
    public static void main(String[] args) {
        try {
            System.out.println("Start");

            MoveDirection[] directions = OptionParser.parse(args);

            GrassField mapa = new GrassField(25);
            mapa.place(new Animal(mapa,new Vector2d(1,1)));
            mapa.place(new Animal(mapa,new Vector2d(8,5)));
            mapa.place(new Animal(mapa,new Vector2d(23,24)));
            mapa.place(new Animal(mapa,new Vector2d(3,5)));
            mapa.place(new Animal(mapa,new Vector2d(8,10)));
            mapa.place(new Animal(mapa,new Vector2d(3,18)));
            mapa.place(new Animal(mapa,new Vector2d(19,4)));
            mapa.place(new Animal(mapa,new Vector2d(1,12)));
            mapa.run(directions);
            System.out.println(mapa.toString());
            System.out.println("Koniec");
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
