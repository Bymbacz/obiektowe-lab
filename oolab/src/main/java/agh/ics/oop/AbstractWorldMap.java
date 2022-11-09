package agh.ics.oop;

import java.util.ArrayList;

abstract public class AbstractWorldMap implements IWorldMap{
    protected ArrayList<Animal> animals = new ArrayList<>();
    public boolean place(Animal animal){
        if (isOccupied(animal.getPosition()) || !canMoveTo(animal.getPosition())) return false;
        this.animals.add(animal);
        return true;
    }
    public boolean isOccupied(Vector2d position){
        for(Animal animal: this.animals){
            if(animal.getPosition().equals(position)) return true;
        }
        return false;
    }
    public Object objectAt(Vector2d position){
        for(Animal animal: this.animals){
            if(animal.getPosition().equals(position)) return animal;
        }
        return null;
    }
    public abstract Vector2d getll();
    public abstract Vector2d getur();
    public String toString(){
        Vector2d ll = getll();
        Vector2d ur = getur();
        MapVisualizer m = new MapVisualizer(this);
        return m.draw(ll,ur);
    }
}
