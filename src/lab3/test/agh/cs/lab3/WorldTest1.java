package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest1 {

    @Test
    public void orientationTest(){
        IWorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(map);
        assertTrue(animal.getOrientation() == MapDirection.NORTH);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.LEFT);
        assertTrue(animal.getOrientation() == MapDirection.NORTH);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.getOrientation() == MapDirection.WEST);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.getOrientation() == MapDirection.WEST);
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.getOrientation() == MapDirection.WEST);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        assertTrue(animal.getOrientation() == MapDirection.EAST);
    }

    @Test
    public void positionTest(){
        IWorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(map);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 2)));
        animal.move(MoveDirection.RIGHT);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 2)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.getPosition().equals(new Vector2d(3, 2)));
        animal.move(MoveDirection.LEFT);
        assertTrue(animal.getPosition().equals(new Vector2d(3, 2)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.getPosition().equals(new Vector2d(3, 1)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.getPosition().equals(new Vector2d(3, 2)));
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 2)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.getPosition().equals(new Vector2d(3, 2)));
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.getPosition().equals(new Vector2d(3, 1)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.getPosition().equals(new Vector2d(3, 2)));
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.getPosition().equals(new Vector2d(4, 2)));
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.getPosition().equals(new Vector2d(3, 2)));
    }

    @Test
    public void boundriesTest(){
        IWorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(map);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 4)));
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.getPosition().equals(new Vector2d(2, 0)));
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.getPosition().equals(new Vector2d(4, 0)));
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.getPosition().equals(new Vector2d(0, 0)));
    }

    @Test
    public void parserTest(){
        String[] inp1 = {"f", "z", "r", "l", "b"};
        MoveDirection[] out = OptionParser.parse(inp1);
        assertTrue(out[0] == MoveDirection.FORWARD);
        assertTrue(out[1] == MoveDirection.RIGHT);
        assertTrue(out[2] == MoveDirection.LEFT);
        assertTrue(out[3] == MoveDirection.BACKWARD);

        String[] inp2 = {"forward", "right", "e", "left", "backward"};
        out = OptionParser.parse(inp2);
        assertTrue(out[0] == MoveDirection.FORWARD);
        assertTrue(out[1] == MoveDirection.RIGHT);
        assertTrue(out[2] == MoveDirection.LEFT);
        assertTrue(out[3] == MoveDirection.BACKWARD);

    }
}