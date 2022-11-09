package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap{
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


    public boolean canMoveTo(Vector2d position){
        return ((position.upperRight(ur).equals(ur)) && (position.lowerLeft(ll).equals(ll)));
    }


    @Override
    public Vector2d getur(){
        return ur;
    }
    @Override
    public Vector2d getll(){
        return ll;
    }
}
