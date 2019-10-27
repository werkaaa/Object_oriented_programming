package agh.cs.lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    public final int width;
    public final int height;
    public List<Animal> animals;
    public MapVisualizer visualizer = new MapVisualizer(this);


    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.animals = new ArrayList<>();
    }

    public String toString(){
        return this.visualizer.draw(new Vector2d(0, 0), new Vector2d(this.width, this.height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.x >= 0 && position.x <= width && position.y >=0 && position.y <= height && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(isOccupied(animal.animalPosition()))
            return false;
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
        for(Animal animal : animals){
            if(animal.animalPosition().equals(position))
                return animal;
        }
        return null;
    }
}
