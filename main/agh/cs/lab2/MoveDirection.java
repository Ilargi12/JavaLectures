package agh.cs.lab2;

public enum MoveDirection {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT;

    public static MoveDirection swapToMoveDirection(String x){
        switch(x){
            case "f":
                case "forward" :
                    return FORWARD;
            case "b":
                case "backward" :
                    return BACKWARD;
            case "r":
                case "right" :
                    return RIGHT;
            case "l":
                case "left" :
                    return LEFT;
            default:
                throw new IllegalArgumentException(x + " is not legal move specification");
        }
    }
}

