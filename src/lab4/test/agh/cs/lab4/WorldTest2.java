package agh.cs.lab4;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionParser;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WorldTest2 {
    @Test
    public void WorldTest(){
        String [] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionParser().parse(args);
        MoveDirection[] toCompare = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT,
                                     MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT,
                                     MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
                                     MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        assertTrue(Arrays.equals(toCompare, directions));

        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(((RectangularMap) map).animals.get(0).getOrientation() == MapDirection.NORTH);

        map.place(new Animal(map,new Vector2d(3,4)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
        assertTrue(((RectangularMap) map).animals.get(1).getOrientation() == MapDirection.NORTH);

        map.run(Arrays.copyOfRange(directions, 0, 4));
        assertTrue(((RectangularMap) map).animals.get(0).getOrientation() == MapDirection.EAST);
        assertTrue(((RectangularMap) map).animals.get(1).getOrientation() == MapDirection.WEST);
        assertTrue(((RectangularMap) map).animals.get(0).getPosition().equals(new Vector2d(2,3)));
        assertTrue(((RectangularMap) map).animals.get(1).getPosition().equals(new Vector2d(3,3)));

        map.run(Arrays.copyOfRange(directions, 4, 8));
        assertTrue(((RectangularMap) map).animals.get(0).getOrientation() == MapDirection.SOUTH);
        assertTrue(((RectangularMap) map).animals.get(1).getOrientation() == MapDirection.NORTH);
        assertTrue(((RectangularMap) map).animals.get(0).getPosition().equals(new Vector2d(2,3)));
        assertTrue(((RectangularMap) map).animals.get(1).getPosition().equals(new Vector2d(3,3)));

        map.run(Arrays.copyOfRange(directions, 8, 12));
        assertTrue(((RectangularMap) map).animals.get(0).getOrientation() == MapDirection.SOUTH);
        assertTrue(((RectangularMap) map).animals.get(1).getOrientation() == MapDirection.NORTH);
        assertTrue(((RectangularMap) map).animals.get(0).getPosition().equals(new Vector2d(2,1)));
        assertTrue(((RectangularMap) map).animals.get(1).getPosition().equals(new Vector2d(3,4)));

        map.run(Arrays.copyOfRange(directions, 12, 16));
        assertTrue(((RectangularMap) map).animals.get(0).getOrientation() == MapDirection.SOUTH);
        assertTrue(((RectangularMap) map).animals.get(1).getOrientation() == MapDirection.NORTH);
        assertTrue(((RectangularMap) map).animals.get(0).getPosition().equals(new Vector2d(2,0)));
        assertTrue(((RectangularMap) map).animals.get(1).getPosition().equals(new Vector2d(3,4)));

        assertTrue(map.isOccupied(new Vector2d(3,4)));
        assertTrue(map.isOccupied(new Vector2d(2,0)));
        assertFalse(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(3,3)));

        map.place(new Animal(map, new Vector2d(100,100)));
        assertFalse(map.isOccupied(new Vector2d(100, 100)));

    }
}
