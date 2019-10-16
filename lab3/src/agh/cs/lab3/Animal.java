package agh.cs.lab3;
import agh.cs.lab2.*;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public String toString(){
        return "Orientation: "+orientation.toString()+" Position: "+position.toString();

    }

    public void move(MoveDirection direction){
        if(direction==MoveDirection.RIGHT){
            orientation.next();
        }
        else if(direction==MoveDirection.LEFT){
            orientation.previous();
        }

    }
}
