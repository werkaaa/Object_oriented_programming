package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public String toString(){
        return "Orientation: "+orientation.toString()+" Position: "+position.toString();
    }

    public MapDirection animalOrientation() {
        return orientation;
    }

    public Vector2d animalPosition() {
        return position;
    }

    private boolean inRange(Vector2d pos){
        Vector2d v_0_0 = new Vector2d(0,0);
        Vector2d v_4_4 = new Vector2d(4,4);
        if(pos.follows(v_0_0) && pos.precedes(v_4_4))
            return true;
        else
            return false;
    }

    public void move(MoveDirection direction){
        Vector2d v_0_1 = new Vector2d(0,1);
        Vector2d v_1_0 = new Vector2d(1,0);

        if(direction==MoveDirection.RIGHT){
            orientation = orientation.next();
        }
        else if(direction==MoveDirection.LEFT){
            orientation = orientation.previous();
        }
        else if(direction==MoveDirection.FORWARD){
            switch (orientation) {
                case NORTH:
                    if(inRange(position.add(v_0_1)))
                        position = position.add(v_0_1);
                    break;
                case SOUTH:
                    if(inRange(position.subtract(v_0_1)))
                        position = position.subtract(v_0_1);
                    break;
                case WEST:
                    if(inRange(position.subtract(v_1_0)))
                        position = position.subtract(v_1_0);
                    break;
                case EAST:
                    if(inRange(position.add(v_1_0)))
                        position = position.add(v_1_0);
                    break;
                default:
                    break;

            }
        }
        else if(direction==MoveDirection.BACKWARD){
            switch (orientation) {
                case NORTH:
                    if(inRange(position.subtract(v_0_1)))
                        position = position.subtract(v_0_1);
                    break;
                case SOUTH:
                    if(inRange(position.add(v_0_1)))
                        position = position.add(v_0_1);
                    break;
                case WEST:
                    if(inRange(position.add(v_1_0)))
                        position = position.add(v_1_0);
                    break;
                case EAST:
                    if(inRange(position.subtract(v_1_0)))
                        position = position.subtract(v_1_0);
                    break;
                default:
                    break;

            }
        }

    }
}
