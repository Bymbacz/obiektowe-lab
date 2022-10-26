package agh.ics.oop;

public class Animal {
    private Vector2d pos = new Vector2d(2,2);
    private MapDirection or = MapDirection.NORTH;

    public String toString(){
        return(pos.toString()+" "+or.toString());
    }
    boolean isAt(Vector2d position){
        return (pos.equals(position));
    }
    void move(MoveDirection direction){
        or = switch (direction){
            case RIGHT -> or.next();
            case LEFT -> or.previous();
            default -> or;
        };
        Vector2d ppos= new Vector2d(pos.x, pos.y);
        pos = switch(direction){
            case FORWARD -> pos.add(or.toUnitVector());
            case BACKWARD -> pos.add(or.next().next().toUnitVector());
            default -> pos;
        };
        Vector2d upper = new Vector2d(4,4);
        Vector2d lower = new Vector2d(0,0);
        if (!pos.upperRight(upper).equals(upper)) pos=ppos;
        if (!pos.lowerLeft(lower).equals(lower)) pos=ppos;
    }
}
