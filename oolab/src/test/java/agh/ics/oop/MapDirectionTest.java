package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {
    @Test
    public void nextTest(){
        Assertions.assertEquals(MapDirection.NORTH.next(),MapDirection.EAST,"not working");
        Assertions.assertEquals(MapDirection.EAST.next(),MapDirection.SOUTH,"not working");
        Assertions.assertEquals(MapDirection.SOUTH.next(),MapDirection.WEST,"not working");
        Assertions.assertEquals(MapDirection.WEST.next(),MapDirection.NORTH,"not working");
    }
    @Test
    public void prevTest(){
        Assertions.assertEquals(MapDirection.NORTH.previous(),MapDirection.WEST,"not working");
        Assertions.assertEquals(MapDirection.EAST.previous(),MapDirection.NORTH,"not working");
        Assertions.assertEquals(MapDirection.SOUTH.previous(),MapDirection.EAST,"not working");
        Assertions.assertEquals(MapDirection.WEST.previous(),MapDirection.SOUTH,"not working");
    }

}
