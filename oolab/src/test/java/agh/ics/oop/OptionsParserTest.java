package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;

public class OptionsParserTest {
    String[] t = {"f","forward","b","backward","r","right","l","left"};
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
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String[] t3 = {"lol"};
            OptionsParser t4 = new OptionsParser();
            MoveDirection[] tab2 = t4.parse(t3);
        });
        Assertions.assertEquals("lol is not legal move specification",thrown.getMessage(), "not working");
    }
}
