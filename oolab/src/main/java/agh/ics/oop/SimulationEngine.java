package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class SimulationEngine implements IEngine,Runnable{
    public MoveDirection[] directions;
    public GrassField map;
    public Vector2d[] positions;
    public int numOfAnimals = 0;
    public int moveDelay;
    public SimulationEngine(GrassField map, Vector2d[] positions, IPositionChangeObserver app, int moveDelay){
        this.map=map;
        this.positions=positions;
        this.moveDelay=moveDelay;
        for(int i=0; i<positions.length; i++){
            Animal zwierz = new Animal(this.map,this.positions[i]);
            if(this.map.place(zwierz)){
                numOfAnimals+=1;
                zwierz.addObserver(app);
            }
        }
    }
    @Override
    public void run(){
        out.println("Thread started.");
        out.println(map.toString());
        for(int i=0; i<this.directions.length; i++){
            Vector2d oldpos =this.map.animalList.get(i%numOfAnimals).getPosition();
            this.map.animalList.get(i%numOfAnimals).move(this.directions[i]);
            this.map.mapB.positionChanged(oldpos,this.map.animalList.get(i%numOfAnimals).getPosition());
            out.println(map.toString());
            try{
                Thread.sleep(moveDelay);
            }catch (InterruptedException e){
                out.println("break symulacji "+e.getMessage());
                break;
            }

        }
        out.println("koniec wątku");

    }
    public void setDirections(String s){
        this.directions = new OptionsParser().parse(s.split(" "));
    }

}