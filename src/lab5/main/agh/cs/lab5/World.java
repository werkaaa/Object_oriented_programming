package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args){
        try {
            MoveDirection[] directions = new OptionParser().parse(args);
            List<Rock> rocks = new ArrayList<>();
            rocks.add(new Rock(new Vector2d(-4, -4)));
            rocks.add(new Rock(new Vector2d(7, 7)));
            rocks.add(new Rock(new Vector2d(3, 6)));
            rocks.add(new Rock(new Vector2d(2, 0)));
            IWorldMap map = new UnboundedMap(rocks);
            System.out.println(map.toString());
            //map.place(new Animal(map));
            map.place(new Animal(map, new Vector2d(3, 4)));
            map.place(new Animal(map, new Vector2d(0, 5)));
            map.run(directions);
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex);
        }
    }
}
