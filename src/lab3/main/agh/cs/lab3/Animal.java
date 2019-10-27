package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;

    public String toLongString(){
        return "Orientation: "+orientation.toString()+" Position: "+position.toString();
    }

    public String toString(){
        switch(orientation){
            case NORTH:
                return "^";
            case EAST:
                return ">";
            case SOUTH:
                return "v";
            case WEST:
                return "<";
            default:
                return "";
        }

    }

    public Animal(){

    }

    public Animal(IWorldMap map) {
        if(!map.isOccupied(new Vector2d(2,2)))
            this.map = map;
        else
            System.out.println("Pozycja (2, 2) jest zajęta! Podaj inną lokalizację zwierzaka.");
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        if(!map.isOccupied(initialPosition)) {
            this.map = map;
            this.position = initialPosition;
        }
        else
            System.out.println("Pozycja "+initialPosition.toString()+" jest zajęta! Podaj inną lokalizację zwierzaka.");

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
        Vector2d newPosition;

        switch(direction){
            case RIGHT:
                orientation = orientation.next();
                break;
            case LEFT:
                orientation = orientation.previous();
                break;
            case FORWARD:
                newPosition = position.add(orientation.toUnitVector());
                if(map.canMoveTo(newPosition)){
                    position = newPosition;
                }
                break;
            case BACKWARD:
                newPosition = position.add(orientation.toUnitVector().opposite());
                if(map.canMoveTo(newPosition)) {
                    position = newPosition;
                }
                break;
        }
        }

    }
