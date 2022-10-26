package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsParserTest {
    String[] t = {"f","forward","b","backward","r","right","l","left","rl","lr"};
    OptionsParser t2 = new OptionsParser();
    MoveDirection[] tab = t2.parse(t);
    @Test
    public void forwardTest(){
        Assertions.assertEquals(MoveDirection.FORWARD,tab[0],"not working");
        Assertions.assertEquals(MoveDirection.FORWARD,tab[1],"not working");
    }
    @Test
    public void backwardTest(){
        Assertions.assertEquals(MoveDirection.BACKWARD,tab[2],"not working");
        Assertions.assertEquals(MoveDirection.BACKWARD,tab[3],"not working");
    }
    @Test
    public void rightTest(){
        Assertions.assertEquals(MoveDirection.RIGHT,tab[4],"not working");
        Assertions.assertEquals(MoveDirection.RIGHT,tab[5],"not working");
    }
    @Test
    public void leftTest(){
        Assertions.assertEquals(MoveDirection.LEFT,tab[6],"not working");
        Assertions.assertEquals(MoveDirection.LEFT,tab[7],"not working");
    }
    @Test
    public void defaultTest(){
        Assertions.assertNotEquals(t.length,tab.length,"not working");
        Assertions.assertEquals(t.length-2,tab.length,"not working");
    }
}
