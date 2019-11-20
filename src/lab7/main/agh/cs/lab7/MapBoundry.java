package agh.cs.lab7;

import agh.cs.lab2.Vector2d;
import agh.cs.lab5.IMapElement;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundry implements IPositionChangeObserver{

    public SortedSet<Vector2d> orderedX = new TreeSet<>((pos1, pos2)-> {
        if (pos1.x < pos2.x || (pos1.x == pos2.x && pos1.y < pos2.y))
            return -1;
        else if (pos1.x == pos2.x && pos1.y == pos2.y)
            return 0;
        else
            return 1;
    });

    public SortedSet<Vector2d> orderedY = new TreeSet<>((pos1, pos2)-> {
        if (pos1.y < pos2.y || (pos1.y == pos2.y && pos1.x < pos2.x))
            return -1;
        else if (pos1.y == pos2.y && pos1.x == pos2.x)
            return 0;
        else
            return 1;
    });

    public MapBoundry(Map elements){
        this.orderedX.addAll(elements.keySet());
        this.orderedY.addAll(elements.keySet());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.orderedX.remove(oldPosition);
        this.orderedX.add(newPosition);
        this.orderedY.remove(oldPosition);
        this.orderedY.add(newPosition);
    }

    public void addElement(IMapElement element){
        orderedX.add(element.getPosition());
        orderedY.add(element.getPosition());
    }
}
