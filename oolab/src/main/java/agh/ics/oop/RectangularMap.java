package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    final int w;
    final int h;
    Vector2d ur;
    Vector2d ll;
    public RectangularMap(int width, int height){
        this.w=width;
        this.h=height;
        ur=new Vector2d(w,h);
        ll = new Vector2d(0,0);
    }
    ArrayList<Animal> animals = new ArrayList<>();


    public boolean canMoveTo(Vector2d position){
        return ((position.upperRight(ur).equals(ur)) && (position.lowerLeft(ll).equals(ll)));
    }

    public boolean place(Animal animal){
        if (isOccupied(animal.getPosition()) || !canMoveTo(animal.getPosition())) return false;
        animals.add(animal);
        return true;
    }

    public boolean isOccupied(Vector2d position){
        for(Animal animal: this.animals){
            if(animal.getPosition().equals(position)){ return true; }
        }
        return false;
    }

    public Object objectAt(Vector2d position){
        for(int i=0; i<animals.size();i++){
            if(animals.get(i).getPosition().equals(position)) return animals.get(i);
        }
        return null;
    }

    public String toString(){
        MapVisualizer m = new MapVisualizer(this);
        return m.draw(ll,ur);
    }
}
