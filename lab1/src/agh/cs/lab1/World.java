package agh.cs.lab1;

import java.util.Arrays;
import static java.lang.System.out;

public class World {

    public static void run(Direction[] args){
        Direction[] subargs = Arrays.copyOfRange(args, 0, args.length-1);
        for(Direction arg : subargs){
            System.out.printf(arg+", ");
        }
        System.out.printf(args[args.length-1]+"\n");

        for(Direction arg : args){
            switch(arg){
                case FORWARD:
                    out.println("Do przodu\n");
                    break;
                case BACKWARD:
                    out.println("Do tyłu\n");
                    break;
                case RIGHT:
                    out.println("Skręca w prawo\n");
                    break;
                case LEFT:
                    out.println("Skręca w lewo\n");
                    break;
                case NOWHERE:
                    out.println("Złe dane\n");
                    break;
            }
        }
    }

    public static Direction[] changeType(String[] args){
        Direction[] dirs = new Direction[args.length];
        for(int i = 0; i<args.length; i++){
            switch(args[i]){
                case "f":
                    dirs[i] = Direction.FORWARD;
                    break;
                case "b":
                    dirs[i] = Direction.BACKWARD;
                    break;
                case "r":
                    dirs[i] = Direction.RIGHT;
                    break;
                case "l":
                    dirs[i] = Direction.LEFT;
                    break;
                default:
                    dirs[i] = Direction.NOWHERE;
            }
        }
        return dirs;
    }

    public static void main(String[] args) {
        System.out.printf("Start\n");
        Direction[] dirs = changeType(args);
        run(dirs);
        System.out.printf("Stop");
    }
}
