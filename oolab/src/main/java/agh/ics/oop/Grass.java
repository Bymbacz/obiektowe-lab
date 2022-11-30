package agh.ics.oop;

public class Grass implements IMapElement{
    private Vector2d position;
    Grass (Vector2d InitialPosition){
        this.position=InitialPosition;
    }
    public Vector2d getPosition(){
        return this.position;
    }
    public String toString(){
        return "*";
    }

    @Override
    public String resourceName() {
        return ("src/main/resources/grass.png");
    }
}
