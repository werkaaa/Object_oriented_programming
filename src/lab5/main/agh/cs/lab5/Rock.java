package agh.cs.lab5;

import agh.cs.lab2.Vector2d;

public class Rock implements IMapElement{
    private Vector2d position;

    public Rock(Vector2d position){
        this.position = position;
    }

    @Override
    public Vector2d getPosition(){
        return this.position;
    }

    @Override
    public String toString(){
        return "r";
    }
}
