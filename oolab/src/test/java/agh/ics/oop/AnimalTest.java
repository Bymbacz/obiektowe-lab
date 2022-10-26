package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;

public class AnimalTest {
    @Test
    public void isAtTest(){
        Animal zwierz = new Animal();
        zwierz.move(MoveDirection.FORWARD);
        zwierz.move(MoveDirection.RIGHT);
        zwierz.move(MoveDirection.FORWARD);
        Vector2d v1 = new Vector2d(3,3);
        Vector2d v2 = new Vector2d(2,4);
        Assertions.assertTrue(zwierz.isAt(v1));
        zwierz.move(MoveDirection.BACKWARD);
        Assertions.assertFalse(zwierz.isAt(v1));
        zwierz.move(MoveDirection.LEFT);
        zwierz.move(MoveDirection.FORWARD);
        zwierz.move(MoveDirection.FORWARD);
        zwierz.move(MoveDirection.FORWARD);
        Assertions.assertTrue(zwierz.isAt(v2));
    }
    @Test
    public void toStringTest(){
        String s = new String("(2,2) Polnoc");
        String s2 = new String("(3,3) Wschod");
        String s3 = new String("(3,3) Zachod");
        Animal zwierz = new Animal();
        Assertions.assertEquals(zwierz.toString(),s,"not working");

        zwierz.move(MoveDirection.FORWARD);
        zwierz.move(MoveDirection.RIGHT);
        zwierz.move(MoveDirection.FORWARD);
        Assertions.assertEquals(zwierz.toString(),s2,"not working");
        zwierz.move(MoveDirection.LEFT);
        zwierz.move(MoveDirection.LEFT);
        Assertions.assertEquals(zwierz.toString(),s3,"not working");
    }
}
