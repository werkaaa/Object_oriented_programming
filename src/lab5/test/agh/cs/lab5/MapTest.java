package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MapTest {
    Vector2d v_3_4 = new Vector2d(3, 4);
    Vector2d v_5_5 = new Vector2d(5, 5);
    Vector2d v_0_0 = new Vector2d(0, 0);
    Vector2d v_2_0 = new Vector2d(2, 0);
    Vector2d v_3_m3 = new Vector2d(3, -3);
    Vector2d v_3_0 = new Vector2d(3, 0);

    @Test
    public void mapTest() {
        List<Rock> rocks = new ArrayList<>();
        rocks.add(new Rock(new Vector2d(-4, -4)));
        rocks.add(new Rock(new Vector2d(7, 7)));
        rocks.add(new Rock(new Vector2d(3, 6)));
        rocks.add(new Rock(new Vector2d(2, 0)));

        IWorldMap uMap = new UnboundedMap(rocks);
        Animal animal1 = new Animal(uMap, new Vector2d(3, 4));
        //Animal animal2 = new Animal(uMap, new Vector2d(-4, -4));

        assertTrue(uMap.place(animal1));
        //assertFalse(uMap.place(animal2));

        IWorldMap rMap = new RectangularMap(5, 5);
        Animal animal3 = new Animal(rMap, new Vector2d(3, 4));
        Animal animal4 = new Animal(rMap, new Vector2d(6, 6));

        assertTrue(rMap.place(animal3));
        //assertFalse(rMap.place(animal4));

        assertFalse(uMap.canMoveTo(v_2_0));
        assertFalse(uMap.canMoveTo(v_3_4));
        assertTrue(uMap.canMoveTo(v_0_0));

        assertFalse(rMap.canMoveTo(v_5_5));
        assertFalse(rMap.canMoveTo(v_3_4));
        assertTrue(rMap.canMoveTo(v_0_0));

        String [] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionParser().parse(args);

        uMap.run(directions);
        rMap.run(directions);

        //assertTrue(uMap.objectAt(v_3_m3).equals(animal1));
        //assertTrue(rMap.objectAt(v_3_0).equals(animal3));

        //assertTrue(uMap.isOccupied(v_3_m3));
        //assertTrue(rMap.isOccupied(v_3_0));
    }

}