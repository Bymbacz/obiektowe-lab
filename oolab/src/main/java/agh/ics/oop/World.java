package agh.ics.oop;

import agh.isc.oop.gui.App;
import javafx.application.Application;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        try {
            String[] s = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
            Application.launch(App.class, s);
        } catch(IllegalArgumentException ex) {
            out.println(ex.getMessage());
        }

    }


    static Direction[] zmiana(String[] t){
        Direction[] tablica = new Direction[t.length];
        int i=0;
        for(String arg: t){
            switch (arg) {
                case "f":
                    tablica[i++]=Direction.FORWARD;
                    break;
                case "b":
                    tablica[i++]=Direction.BACKWARD;
                    break;
                case "r":
                    tablica[i++]=Direction.RIGHT;
                    break;
                case "l":
                    tablica[i++]=Direction.LEFT;
                    break;
            }
        }
        if (i< tablica.length){
            Direction[] tab2 = new Direction[i];
            for(int x=0; x<i; x++) {
                tab2[x]=tablica[x];
            }
            return tab2;
        }
        else{
            return tablica;
        }

    }
    static void run(Direction[] args){
        for(Direction arg: args){
            String message = switch (arg) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
                default -> "";
            };
            if (!message.equals("")){
                out.println(message);
            }
        }
    }
}
