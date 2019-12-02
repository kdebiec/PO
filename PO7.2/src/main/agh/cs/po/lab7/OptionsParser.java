package agh.cs.po.lab7;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    static public MoveDirection[] parse(String[] arr) {
        List<MoveDirection> list = new ArrayList<>();

        for(String arg: arr) {
            switch(arg) {
                case "f":
                case "forward":
                    list.add(MoveDirection.FORWARD);
                    break;
                case "b":
                case "backward":
                    list.add(MoveDirection.BACKWARD);
                    break;
                case "r":
                case "right":
                    list.add(MoveDirection.RIGHT);
                    break;
                case "l":
                case "left":
                    list.add(MoveDirection.LEFT);
                    break;
                default:
                    throw new IllegalArgumentException(arg + " is invalid");
            }
        }

        return list.toArray(new MoveDirection[0]);
    }
}
