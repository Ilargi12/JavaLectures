package agh.cs.lab2;

public  class OptionParser {

    public static MoveDirection[] parse(String[] args){
        MoveDirection[] tab1 = new MoveDirection[args.length];
        for(int i=0; i < args.length; i++){
            tab1[i] = MoveDirection.swapToMoveDirection(args[i]);
        }
        return tab1;
    }

}
