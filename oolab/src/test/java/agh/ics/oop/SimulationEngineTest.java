package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimulationEngineTest {
    @Test
    public void simulationEngineTest() {
        String[] s = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(s);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Vector2d v1 = new Vector2d(10, 10);
        Vector2d v2 = new Vector2d(2, 0);
        Assertions.assertTrue(map.canMoveTo(v2),"not working");
        Assertions.assertFalse(map.canMoveTo(v1),"not working");
        Animal zwierz1 = new Animal(map, new Vector2d(1, 2));
        Animal zwierz2 = new Animal(map, v2);
        Assertions.assertFalse(map.place(zwierz2),"not working");
        Assertions.assertTrue(map.place(zwierz1),"not working");
        Assertions.assertEquals(zwierz1, map.objectAt(new Vector2d(1, 2)),"not working");
        Assertions.assertTrue(map.isOccupied(v2),"not working");
        Assertions.assertFalse(map.isOccupied(new Vector2d(3, 3)),"not working");
    }
}
