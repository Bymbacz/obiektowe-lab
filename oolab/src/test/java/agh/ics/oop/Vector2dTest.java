package agh.ics.oop;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    public void ToStringTest(){
        Vector2d v1 = new Vector2d(1,3);
        Vector2d v2 = new Vector2d(2,5);
        String v3 = "(1,3)";
        Assertions.assertEquals(v1.toString(),v3,"not working");
        Assertions.assertNotEquals(v2.toString(),v3,"not working");
    }
    @Test
    public void equalsTest(){
        Vector2d v1 = new Vector2d(1,3);
        Vector2d v2 = new Vector2d(2,5);
        Vector2d v3 = new Vector2d(1,3);
        Assertions.assertTrue(v1.equals(v3),"not working");
        Assertions.assertFalse(v2.equals(v3),"not working");
    }
    @Test
    public void precedsTest(){
        Vector2d v1 = new Vector2d(1,4);
        Vector2d v2 = new Vector2d(2,5);
        Vector2d v3 = new Vector2d(1,3);
        Assertions.assertTrue(v2.precedes(v1),"not working");
        Assertions.assertFalse(v3.precedes(v1),"not working");
    }
    @Test
    public void followsTest(){
        Vector2d v1 = new Vector2d(1,4);
        Vector2d v2 = new Vector2d(2,5);
        Vector2d v3 = new Vector2d(1,3);
        Assertions.assertTrue(v1.follows(v2),"not working");
        Assertions.assertFalse(v1.follows(v3),"not working");
    }
    @Test
    public void addTest(){
        Vector2d v1 = new Vector2d(1,4);
        Vector2d v2 = new Vector2d(2,5);
        Vector2d v3 = new Vector2d(3,9);
        Assertions.assertEquals(v1.add(v2),v3,"not working");
        Assertions.assertNotEquals(v1.add(v3),v2,"not working");
    }
    @Test
    public void substractTest(){
        Vector2d v1 = new Vector2d(1,4);
        Vector2d v2 = new Vector2d(2,5);
        Vector2d v3 = new Vector2d(3,9);
        Assertions.assertEquals(v3.subtract(v2),v1,"not working");
        Assertions.assertNotEquals(v1.subtract(v3),v2,"not working");
    }
    @Test
    public void upperRightTest(){
        Vector2d v1 = new Vector2d(1,4);
        Vector2d v2 = new Vector2d(2,1);
        Vector2d v3 = new Vector2d(2,4);
        Assertions.assertEquals(v1.upperRight(v2),v3,"not working");
        Assertions.assertNotEquals(v1.upperRight(v3),v2,"not working");
    }
    @Test
    public void lowerLeftTest(){
        Vector2d v1 = new Vector2d(1,4);
        Vector2d v2 = new Vector2d(2,1);
        Vector2d v3 = new Vector2d(1,1);
        Assertions.assertEquals(v1.lowerLeft(v2),v3,"not working");
        Assertions.assertNotEquals(v1.lowerLeft(v3),v2,"not working");
    }
    @Test
    public void oppositeTest(){
        Vector2d v1 = new Vector2d(1,4);
        Vector2d v2 = new Vector2d(2,1);
        Vector2d v3 = new Vector2d(-1,-4);
        Assertions.assertEquals(v1.opposite(),v3,"not working");
        Assertions.assertNotEquals(v1.opposite(),v2,"not working");
    }
}
