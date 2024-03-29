package agh.cs.lab2;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return String.format("(%s, %s)",x,y);
    }

    @Override
    public int hashCode() {
        return 13 + (this.x * 31) + (this.y * 17);
    }

    public boolean precedes(Vector2d other){
        if (other==null)
            return true;

        return (this.x <= other.x && this.y <= other.y);
    }

    public boolean follows(Vector2d other){
        if (other==null)
            return true;

        return (this.x >= other.x && this.y >= other.y);
    }

    public Vector2d upperRight(Vector2d other){
        if (other==null)
            return this;

        return new Vector2d(Math.max(x,other.x),Math.max(y,other.y));
    }

    public Vector2d lowerLeft(Vector2d other){
        if (other==null)
            return this;

        return new Vector2d(Math.min(x,other.x),Math.min(y,other.y));
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d substract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public boolean equals(Object other){
        if(this == other)
            return true;
        if(!(other instanceof Vector2d))
            return false;
        
        Vector2d that = (Vector2d) other;
        return this.x == that.x && this.y == that.y;
    }

    public Vector2d opposite(){
        Vector2d result = new Vector2d(-this.x,-this.y);
        return result;
    }


}
