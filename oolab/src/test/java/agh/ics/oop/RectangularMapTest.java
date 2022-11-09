package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {
    @Test
    public void RecTest(){
        RectangularMap map = new RectangularMap(5,5);
        Animal zwierz = new Animal(map,new Vector2d(4,4));
        Animal zwierz2 = new Animal(map,new Vector2d(5,6));
        Assertions.assertFalse(map.isOccupied(new Vector2d(4,4)),"zle 1");
        Assertions.assertTrue(map.place(zwierz),"zle 2");
        Assertions.assertTrue(map.isOccupied(new Vector2d(4,4)),"zle 3");
        Assertions.assertFalse(map.place(zwierz2),"zle 4");
        Assertions.assertFalse(map.canMoveTo(new Vector2d(6,6)),"zle 5");
        Assertions.assertFalse(map.canMoveTo(new Vector2d(-1,0)),"zle 6");
        Assertions.assertTrue(map.canMoveTo(new Vector2d(5,5)),"zle 7");
        Assertions.assertEquals(map.objectAt(new Vector2d(0,0)),null,"zle 8");
        Assertions.assertEquals(map.objectAt(new Vector2d(4,4)),zwierz,"zle 9");
    }
}
