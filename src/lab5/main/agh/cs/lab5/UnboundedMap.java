package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {
    protected List<IMapElement> rocks;

    public UnboundedMap(List<IMapElement> rocks){
        this.rocks = rocks;
    }

    public String toString(){
        int minX, maxX, minY, maxY;
        if(this.rocks.size()!=0){
            minX = this.rocks.get(0).getPosition().x;
            maxX = this.rocks.get(0).getPosition().x;
            minY = this.rocks.get(0).getPosition().y;
            maxY = this.rocks.get(0).getPosition().y;
        }
        else if(this.animals.size()!=0){
            minX = this.animals.get(0).getPosition().x;
            maxX = this.animals.get(0).getPosition().x;
            minY = this.animals.get(0).getPosition().y;
            maxY = this.animals.get(0).getPosition().y;
        }
        else
        {
            return this.visualizer.draw(new Vector2d(0, 0), new Vector2d(5, 5));
        }
        Vector2d pos;
        for(IMapElement rock : this.rocks){
            pos = rock.getPosition();
            if(pos.x>maxX)
                maxX = pos.x;
            else if(pos.x < minX)
                minX = pos.x;

            if(pos.y>maxY)
                maxY = pos.y;
            else if(pos.y<minY)
                minY = pos.y;
        }
        return this.visualizer.draw(new Vector2d(minX, minY), new Vector2d(maxX, maxY));
    }

    public Object objectAt(Vector2d position) {
        if(this.rocks!=null) {
            for (IMapElement rock : rocks) {
                if (rock.getPosition().equals(position))
                    return rock;
            }
        }
        return super.objectAt(position);
    }

}
