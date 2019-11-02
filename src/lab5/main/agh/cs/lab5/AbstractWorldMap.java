package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    public List<Animal> animals = new ArrayList<>();
    protected MapVisualizer visualizer = new MapVisualizer(this);

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getPosition())) {
            System.out.println("Zwierzę w złym miejscu.");
            return false;
        }
        else{
            this.animals.add(animal);
            return true;
        }
    }

    @Override
    public void run(MoveDirection[] directions) {
        int n = animals.size();
        int iter = 0;

        System.out.println(this);
        for( Animal animal : this.animals) {
            System.out.println(animal.toLongString());
        }
        System.out.println("----------------------------\n");
        for(MoveDirection dir : directions){
            this.animals.get(iter).move(dir);

            System.out.println(this);
            for( Animal animal : this.animals) {
                System.out.println(animal.toLongString());
            }
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
        if(this.animals!=null) {
            for (Animal animal : animals) {
                if (animal.getPosition().equals(position))
                    return animal;
            }
        }

        return null;
    }

}
