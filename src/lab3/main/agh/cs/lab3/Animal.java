package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.IMapElement;
import agh.cs.lab7.IPositionChangeObserver;

import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement{
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public String toLongString(){
        return "Orientation: "+orientation.toString()+" Position: "+position.toString();
    }

    @Override
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

    public Animal(IWorldMap map) {
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
            this.orientation = MapDirection.NORTH;
            this.map = map;
            this.position = initialPosition;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    @Override
    public Vector2d getPosition() {
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
                    this.positionChanged(position, newPosition);
                    position = newPosition;
                }
                break;
            case BACKWARD:
                newPosition = position.add(orientation.toUnitVector().opposite());
                if(map.canMoveTo(newPosition)) {
                    this.positionChanged(position, newPosition);
                    position = newPosition;
                }
                break;
        }
        }

        public void addObserver(IPositionChangeObserver observer){
            this.observers.add(observer);
        }

        private void removeObserver(IPositionChangeObserver observer){
            this.observers.remove(observer);
        }

        private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
            for(IPositionChangeObserver observer : this.observers){
                observer.positionChanged(oldPosition, newPosition);
            }
        }

    }
