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
        Assertions.assertTrue(map.place(zwierz),"zle 2");
        Assertions.assertTrue(map.isOccupied(new Vector2d(4,4)),"zle 3");
        Assertions.assertTrue(map.place(zwierz2),"zle 4");

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            map.place(zwierz3);
        });
        Assertions.assertEquals("(-10,-10) is incorrect",thrown.getMessage(), "not working");

        Assertions.assertTrue(map.canMoveTo(new Vector2d(6,6)),"zle 5");
        Assertions.assertFalse(map.canMoveTo(new Vector2d(-1,0)),"zle 6");
        Assertions.assertTrue(map.canMoveTo(new Vector2d(10000,10000)));
        Assertions.assertEquals(map.objectAt(new Vector2d(4,4)),zwierz,"zle 9");
    }
}
