package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;
    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
    boolean precedes(Vector2d other){
        return ((other.x<=x) && (other.y<=y));
    }
    boolean follows(Vector2d other){
        return ((other.x>=x) && (other.y>=y));
    }
    Vector2d add(Vector2d other){
        return new Vector2d(other.x+x, other.y+y);
    }
    Vector2d subtract(Vector2d other){
        return new Vector2d(x-other.x, y-other.y);
    }
    Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(x,other.x), Math.max(y,other.y));
    }
    Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(x,other.x), Math.min(y,other.y));
    }
    Vector2d opposite(){
        return new Vector2d(-x, -y);
    }
    public boolean equals(Object other){
        if (other instanceof Vector2d) {
            return ((x == ((Vector2d) other).x) && (y == ((Vector2d) other).y));
        }
        else return false;
    }
}