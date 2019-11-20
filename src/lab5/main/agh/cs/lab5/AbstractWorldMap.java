package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab7.IPositionChangeObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected MapVisualizer visualizer = new MapVisualizer(this);
    public Map<Vector2d, IMapElement> elements = new HashMap<>();



    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getPosition())) {
            throw new IllegalArgumentException("Place " +animal.getPosition()+" is already taken or is out of border");
        }
        else{
            this.elements.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
    }

    @Override
    public void run(MoveDirection[] directions){
        List<Animal> animals = new ArrayList<>();
        for(IMapElement element : elements.values()){
            if (element instanceof Animal){
                animals.add((Animal) element);
            }
        }
        int n = animals.size();
        int iter = 0;

        System.out.println(this);

        System.out.println("----------------------------\n");
        for(MoveDirection dir : directions){
            Vector2d curr = animals.get(iter).getPosition();
            animals.get(iter).move(dir);

            System.out.println(this);
            System.out.println("----------------------------\n");
            iter = (iter+1)%n;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (objectAt(position)!=null)
            return true;
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(this.elements!=null) {
            return this.elements.get(position);
        }

        return null;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = (Animal) this.elements.remove(oldPosition);
        this.elements.put(newPosition, animal);
    }



}
