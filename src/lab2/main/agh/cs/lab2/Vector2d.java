package agh.cs.lab2;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "("+this.x+","+this.y+")";
    }

    public int hashCode(){
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }

    public boolean precedes(Vector2d other){
        return (this.x <= other.x) && (this.y <= other.y);
    }

    public boolean follows(Vector2d other){
        return (this.x >= other.x) && (this.y >= other.y);
    }

    public Vector2d upperRight(Vector2d other){
        Vector2d uR = new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
        return uR;
    }

    public Vector2d lowerLeft(Vector2d other) {
        Vector2d lL = new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
        return lL;
    }

    public Vector2d add(Vector2d other){
        Vector2d sum = new Vector2d(this.x + other.x, this.y + other.y);
        return sum;
    }

    public Vector2d subtract(Vector2d other){
        Vector2d dif = new Vector2d(this.x - other.x, this.y - other.y);
        return dif;
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if(!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return this.x == that.x && this.y == that.y;
    }

    public Vector2d opposite(){
        return new Vector2d(-1*this.x, -1*this.y);
    }

}
