package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

public class World {
    public static void main(String[] args){
        Animal animal = new Animal();
        System.out.println(animal.toString());
        MoveDirection directions[] = OptionParser.parse(args);
        for(MoveDirection dir : directions){
            animal.move(dir);
        }
        System.out.println(animal.toString());

    }
}
