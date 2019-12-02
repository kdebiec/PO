import agh.cs.po.lab7.MapDirection;
import agh.cs.po.lab7.MoveDirection;
import agh.cs.po.lab7.Vector2d;
import agh.cs.po.lab7.Animal;
import agh.cs.po.lab7.IWorldMap;
import agh.cs.po.lab7.OptionsParser;
import agh.cs.po.lab7.RectangularMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangularMapTest {

    @Test
    public void run() {
        MoveDirection[] directions = new OptionsParser().parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);

        IWorldMap map2 = new RectangularMap(10, 5);
        map2.place(new Animal(map2, new Vector2d(2, 0), MapDirection.SOUTH));
        map2.place(new Animal(map2, new Vector2d(3,4)));

        assertEquals(map.toString(), map2.toString());
    }

    @Test
    public void canMoveTo() {
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        assertEquals(map.canMoveTo(new Vector2d(2,2)), false);
        assertEquals(map.canMoveTo(new Vector2d(11,6)), false);
        assertEquals(map.canMoveTo(new Vector2d(2,1)), true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void place() {
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        //assertEquals(map.place(new Animal(map)), false);
        assertEquals(map.place(new Animal(map, new Vector2d(2, 0))), true);
        map.place(new Animal(map)); // Should throw exception
    }

    @Test
    public void isOccupied() {
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        assertEquals(map.isOccupied(new Vector2d(2,2)), true);
        assertEquals(map.isOccupied(new Vector2d(11,6)), false);
        assertEquals(map.isOccupied(new Vector2d(2,1)), false);
    }

    @Test
    public void objectAt() {
        IWorldMap map = new RectangularMap(10, 5);
        Animal jaksolka = new Animal(map);
        map.place(jaksolka);
        assertEquals(map.objectAt(new Vector2d(2,2)).toString(), jaksolka.toString());
    }
}