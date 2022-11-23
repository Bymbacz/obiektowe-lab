package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class SimulationEngine implements IEngine{
    public MoveDirection[] directions;
    public GrassField map;
    public Vector2d[] positions;
    public int numOfAnimals = 0;
    public SimulationEngine(MoveDirection[] directions, GrassField map, Vector2d[] positions){
        this.directions=directions;
        this.map=map;
        this.positions=positions;
        for(int i=0; i<positions.length; i++){
            if(this.map.place(new Animal(this.map,this.positions[i]))) numOfAnimals+=1;
        }
    }
    public void run(){
        out.println(map.toString());
        for(int i=0; i<this.directions.length; i++){
            Vector2d oldpos =this.map.animalList.get(i%numOfAnimals).getPosition();
            this.map.animalList.get(i%numOfAnimals).move(this.directions[i]);
            this.map.mapB.positionChanged(oldpos,this.map.animalList.get(i%numOfAnimals).getPosition());
            out.println(map.toString());
        }
    }
}