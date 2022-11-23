package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap,IPositionChangeObserver{
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected ArrayList<Animal> animalList = new ArrayList<>();
    public boolean place(Animal animal){
        if (isOccupied(animal.getPosition()) || !canMoveTo(animal.getPosition())) return false;
        this.animals.put(animal.getPosition(), animal);
        this.animalList.add(animal);
        animal.addObserver(this);
        return true;
    }
    public boolean isOccupied(Vector2d position){
        return animals.containsKey(position);
    }
    public Object objectAt(Vector2d position){
        return animals.get(position);
    }
    public abstract Vector2d getll();
    public abstract Vector2d getur();

    public String toString(){
        Vector2d ll = getll();
        Vector2d ur = getur();
        MapVisualizer m = new MapVisualizer(this);
        return m.draw(ll,ur);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }
}
