package agh.cs.lab4;

import agh.cs.lab2.Vector2d;
import agh.cs.lab5.AbstractWorldMap;

public class RectangularMap extends AbstractWorldMap {

    public final Vector2d bl;
    public final Vector2d tr;

    public RectangularMap(int width, int height) {
        bl = new Vector2d(0,0);
        tr = new Vector2d(width-1, height-1);
    }

    public String toString() {
        return this.visualizer.draw(bl, tr);
    }

    public boolean canMoveTo(Vector2d position) {
        return position.follows(bl) && position.precedes(tr) && !isOccupied(position);
    }
}
