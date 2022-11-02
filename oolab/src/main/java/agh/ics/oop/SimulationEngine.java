package agh.ics.oop;

import java.util.ArrayList;

import static java.lang.System.out;

public class SimulationEngine implements IEngine{
    public MoveDirection[] directions;
    public RectangularMap map;
    public Vector2d[] positions;
    public int numOfAnimals = 0;
    public SimulationEngine(MoveDirection[] directions, RectangularMap map, Vector2d[] positions){
        this.directions=directions;
        this.map=map;
        this.positions=positions;
        for(int i=0; i<positions.length; i++){
            if(this.map.place(new Animal(this.map,this.positions[i]))) this.numOfAnimals+=1;
        }
    }
    public void run(){
        //out.println(map.toString());
        for(int i=0; i<this.directions.length; i++){
            this.map.animals.get(i%numOfAnimals).move(this.directions[i]);
            //out.println(map.toString());
        }
    }
}