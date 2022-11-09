package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {
    @Test
    public void GrassTest(){
        GrassField map = new GrassField(10);
        Animal zwierz = new Animal(map,new Vector2d(4,4));
        Animal zwierz2 = new Animal(map,new Vector2d(5,6));
        Animal zwierz3 = new Animal(map,new Vector2d(-10,-10));
        Assertions.assertFalse(map.isOccupied(new Vector2d(4,4)),"zle 1");
        Assertions.assertTrue(map.place(zwierz),"zle 2");
        Assertions.assertTrue(map.isOccupied(new Vector2d(4,4)),"zle 3");
        Assertions.assertTrue(map.place(zwierz2),"zle 4");
        Assertions.assertFalse(map.place(zwierz3),"zle 4.5");
        Assertions.assertTrue(map.canMoveTo(new Vector2d(6,6)),"zle 5");
        Assertions.assertFalse(map.canMoveTo(new Vector2d(-1,0)),"zle 6");
        Assertions.assertTrue(map.canMoveTo(new Vector2d(10000,10000)));
        Assertions.assertEquals(map.objectAt(new Vector2d(0,0)),null,"zle 8");
        Assertions.assertEquals(map.objectAt(new Vector2d(4,4)),zwierz,"zle 9");
    }
}
