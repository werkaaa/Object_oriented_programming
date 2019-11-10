package agh.cs.lab5;

import agh.cs.lab2.Vector2d;

import java.util.List;


public class UnboundedMap extends AbstractWorldMap {

    public UnboundedMap(List<Rock> rocks){
        for( Rock rock : rocks){
            this.elements.put(rock.getPosition(), rock);
        }

    }

    @Override
    public String toString(){

        Vector2d lowerLeft = null;
        Vector2d upperRight = null;

        for(Vector2d key : this.elements.keySet()){
            if(lowerLeft==null)
                lowerLeft = this.elements.get(key).getPosition();
            else {
                lowerLeft = lowerLeft.lowerLeft(this.elements.get(key).getPosition());

            }
            if(upperRight==null)
                upperRight= this.elements.get(key).getPosition();
            else {
                upperRight = upperRight.upperRight(this.elements.get(key).getPosition());
            }
        }

        return visualizer.draw(lowerLeft, upperRight);

   }

}
