package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        /*out.println("system wystartował");
        //String[] t = {"f","f","s","r","l"};
        Direction[] Tab = zmiana(args);
        MapDirection[] mapa = new MapDirection[3];
        mapa[0]=MapDirection.NORTH;
        mapa[1]=MapDirection.EAST;
        mapa[2]=MapDirection.NORTH;
        run(Tab);
        out.println("system zakończył działanie");*/
        /*Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        out.println(mapa[0].toString());
        out.println(mapa[0].next());
        out.println(mapa[2].previous());
        out.println(mapa[2].toUnitVector());
        out.println(mapa[1].toUnitVector());*/
        Animal zwierz = new Animal();
        String[] t = {"f","b","right","f","f","forward"};
        OptionsParser tablicka = new OptionsParser();
        MoveDirection[] tablica_move = tablicka.parse(t);
        for(int i=0; i<tablica_move.length; i++){
            out.println(zwierz.toString());
            zwierz.move(tablica_move[i]);
        }
        /*zwierz.move(MoveDirection.RIGHT);
        zwierz.move(MoveDirection.FORWARD);
        zwierz.move(MoveDirection.FORWARD);
        zwierz.move(MoveDirection.FORWARD);*/
        out.println(zwierz.toString());
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
        //out.println("Zwierzak idzie do przodu");
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
