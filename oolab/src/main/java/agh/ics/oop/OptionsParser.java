package agh.ics.oop;

import static java.lang.System.out;

public class OptionsParser {
    public MoveDirection[] parse(String[] s){
        MoveDirection[] tablica = new MoveDirection[s.length];
        int i=0;
        for(String arg: s){
            switch (arg) {
                case "f":
                    tablica[i++]=MoveDirection.FORWARD;
                    break;
                case "forward":
                    tablica[i++]=MoveDirection.FORWARD;
                    break;
                case "b":
                    tablica[i++]=MoveDirection.BACKWARD;
                    break;
                case "backward":
                    tablica[i++]=MoveDirection.BACKWARD;
                    break;
                case "r":
                    tablica[i++]=MoveDirection.RIGHT;
                    break;
                case "right":
                    tablica[i++]=MoveDirection.RIGHT;
                    break;
                case "l":
                    tablica[i++]=MoveDirection.LEFT;
                    break;
                case "left":
                    tablica[i++]=MoveDirection.LEFT;
                    break;
                default:
                    throw new IllegalArgumentException(arg + " is not legal move specification");
            }
        }
        if (i< tablica.length){
            MoveDirection[] tab2 = new MoveDirection[i];
            for(int x=0; x<i; x++) {
                tab2[x]=tablica[x];
            }
            return tab2;
        }
        else{
            return tablica;
        }
    }
}
