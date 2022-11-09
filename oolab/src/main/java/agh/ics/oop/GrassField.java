package agh.ics.oop;


import java.util.ArrayList;

import static java.lang.System.out;

public class GrassField extends AbstractWorldMap{
    public int ngrass;
    public int max_x =0;
    public int min_x =Integer.MAX_VALUE;
    public int max_y =0;
    public int min_y =Integer.MAX_VALUE;
    public ArrayList<Grass> field = new ArrayList<>();
    public GrassField (int NumOfGrass){
        this.ngrass=NumOfGrass;
        int i = 0;
        while(i<ngrass){
            int x=0;
            int y=0;
            Vector2d pos = new Vector2d(x,y);
            x = (int)(Math.random() * ((Math.sqrt(ngrass*10) + 1)));
            y = (int)(Math.random() * ((Math.sqrt(ngrass*10) + 1)));
            max_x=Math.max(max_x,x);
            max_y=Math.max(max_y,y);
            min_x=Math.min(min_x,x);
            min_y=Math.min(min_y,y);
            pos=new Vector2d(x,y);
            if (objectAt(pos) == null){
                Grass grass=new Grass(pos);
                field.add(grass);
                i+=1;
            };
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Vector2d low = new Vector2d(0,0);
        return (low.lowerLeft(position).equals(low));
    }

    public boolean isOccupied(Vector2d position){
        if (super.isOccupied(position)) return true;
        for(Grass grass: this.field){
            if(grass.getPosition().equals(position)) return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if(object!=null) return object;
        for(Grass grass: this.field){
            if(grass.getPosition().equals(position)) return grass;
        }
        return null;
    }
    @Override
    public Vector2d getll(){
        Vector2d ll = new Vector2d(min_x,min_y);
        for (Animal animal: this.animals){
            ll=ll.lowerLeft(animal.getPosition());
        }
        return ll;
    }
    @Override
    public Vector2d getur(){
        Vector2d ur = new Vector2d(max_x,max_y);
        for (Animal animal: this.animals){
            ur=ur.upperRight(animal.getPosition());
        }
        return ur;
    }
}
