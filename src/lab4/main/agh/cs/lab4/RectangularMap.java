package agh.cs.lab4;

import agh.cs.lab2.Vector2d;
import agh.cs.lab5.AbstractWorldMap;

public class RectangularMap extends AbstractWorldMap {

    public final Vector2d lowerLeft;
    public final Vector2d upperRight;

    public RectangularMap(int width, int height) {
        lowerLeft = new Vector2d(0,0);
        upperRight = new Vector2d(width-1, height-1);
    }
    @Override
    public String toString() {
        return visualizer.draw(lowerLeft, upperRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight) && !isOccupied(position);
    }
}
