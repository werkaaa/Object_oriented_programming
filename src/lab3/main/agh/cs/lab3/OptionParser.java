package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

public class OptionParser {

    public static MoveDirection[] parse(String[] dirs){
        MoveDirection[] ans = new MoveDirection[dirs.length];
        int j = 0;
        for(int i = 0; i < dirs.length; i++){
            switch (dirs[i]){
                case "f":
                case "forward":
                    ans[j] = MoveDirection.FORWARD;
                    j++;
                    break;
                case "b":
                case "backward":
                    ans[j] = MoveDirection.BACKWARD;
                    j++;
                    break;
                case "r":
                case "right":
                    ans[j] = MoveDirection.RIGHT;
                    j++;
                    break;
                case "l":
                case "left":
                    ans[j] = MoveDirection.LEFT;
                    j++;
                    break;
                default:
                    break;
            }
        }
        return ans;
    }

}
