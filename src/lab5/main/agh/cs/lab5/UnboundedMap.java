package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab7.MapBoundry;

import java.util.List;


public class UnboundedMap extends AbstractWorldMap {
    MapBoundry mapB;

    public UnboundedMap(List<Rock> rocks){
        for( Rock rock : rocks){
            this.elements.put(rock.getPosition(), rock);
        }
        this.mapB = new MapBoundry(this.elements);
    }

    @Override
    public String toString(){

        Vector2d lowerLeft = new Vector2d(this.mapB.orderedX.first().x, this.mapB.orderedY.first().y);
        Vector2d upperRight = new Vector2d(this.mapB.orderedX.last().x, this.mapB.orderedY.last().y);

        return visualizer.draw(lowerLeft, upperRight);
   }

   @Override
    public boolean place(Animal animal){
        if(super.place(animal)){
            this.mapB.addElement(animal);
            animal.addObserver(mapB);
            return true;
        }
        return false;
   }

}
