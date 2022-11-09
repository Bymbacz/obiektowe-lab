package agh.ics.oop;

public class Animal{
    private Vector2d pos = new Vector2d(2,2);
    private MapDirection or = MapDirection.NORTH;
    IWorldMap map;
    public Animal(IWorldMap map){
        this.map=map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map=map;
        this.pos=initialPosition;
    }

    public Vector2d getPosition() {
        return this.pos;
    }

    public MapDirection getOriented() {
        return this.or;
    }
    public String toString(){
        String s = switch(this.or){
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
        return s;
    }
    public boolean isAt(Vector2d position){
        return (this.pos.equals(position));
    }
    void move(MoveDirection direction){
        this.or = switch (direction){
            case RIGHT -> this.or.next();
            case LEFT -> this.or.previous();
            default -> this.or;
        };
        Vector2d ppos= new Vector2d(this.pos.x, this.pos.y);
        ppos = switch(direction){
            case FORWARD -> ppos.add(this.or.toUnitVector());
            case BACKWARD -> ppos.add(this.or.next().next().toUnitVector());
            default -> ppos;
        };
        if (map.canMoveTo(ppos)){
            if (!map.isOccupied(ppos) || map.objectAt(ppos).toString().equals("*")){
                this.pos=ppos;
            }
        }
    }
}
