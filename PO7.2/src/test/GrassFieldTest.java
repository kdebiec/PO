//package test;

import agh.cs.po.lab7.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GrassFieldTest {

    @Test
    public void run() {
        MoveDirection[] directions = new OptionsParser().parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        ArrayList<Grass> grasses = new ArrayList<>();
        grasses.add(new Grass(new Vector2d(-4, -4)));
        grasses.add(new Grass(new Vector2d(7, 7)));
        grasses.add(new Grass(new Vector2d(3, 6)));
        grasses.add(new Grass(new Vector2d(2, 0)));
        IWorldMap map = new GrassField(grasses);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);

        IWorldMap map2 = new GrassField(grasses);
        map2.place(new Animal(map2, new Vector2d(2, -1), MapDirection.SOUTH));
        map2.place(new Animal(map2, new Vector2d(3,7)));

        assertEquals(map.toString(), map2.toString());
    }

    @Test
    public void canMoveTo() {
        ArrayList<Grass> grasses = new ArrayList<>();
        grasses.add(new Grass(new Vector2d(-4, -4)));
        grasses.add(new Grass(new Vector2d(7, 7)));
        grasses.add(new Grass(new Vector2d(3, 6)));
        grasses.add(new Grass(new Vector2d(2, 0)));

        IWorldMap map = new GrassField(grasses);
        map.place(new Animal(map));
        assertEquals(map.canMoveTo(new Vector2d(2,2)), false);
        assertEquals(map.canMoveTo(new Vector2d(7,7)), true);
        assertEquals(map.canMoveTo(new Vector2d(2,1)), true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void place() {
        ArrayList<Grass> grasses = new ArrayList<>();
        grasses.add(new Grass(new Vector2d(-4, -4)));
        grasses.add(new Grass(new Vector2d(7, 7)));
        grasses.add(new Grass(new Vector2d(3, 6)));
        grasses.add(new Grass(new Vector2d(2, 0)));

        IWorldMap map = new GrassField(grasses);
        map.place(new Animal(map));
        //assertEquals(map.place(new Animal(map)), false);
        assertEquals(map.place(new Animal(map, new Vector2d(2, 0))), true);
        assertEquals(map.place(new Animal(map, new Vector2d(2, 1))), true);

        map.place(new Animal(map)); // Should throw exception
    }

    @Test
    public void isOccupied() {
        ArrayList<Grass> grasses = new ArrayList<>();
        grasses.add(new Grass(new Vector2d(-4, -4)));
        grasses.add(new Grass(new Vector2d(7, 7)));
        grasses.add(new Grass(new Vector2d(3, 6)));
        grasses.add(new Grass(new Vector2d(2, 0)));

        IWorldMap map = new GrassField(grasses);
        map.place(new Animal(map));
        assertEquals(map.isOccupied(new Vector2d(2,2)), true);
        assertEquals(map.isOccupied(new Vector2d(11,6)), false);
        assertEquals(map.isOccupied(new Vector2d(2,1)), false);
        assertEquals(map.isOccupied(new Vector2d(2,0)), true);
    }

    @Test
    public void objectAt() {
        ArrayList<Grass> grasses = new ArrayList<>();
        grasses.add(new Grass(new Vector2d(-4, -4)));
        grasses.add(new Grass(new Vector2d(7, 7)));
        grasses.add(new Grass(new Vector2d(3, 6)));
        grasses.add(new Grass(new Vector2d(2, 0)));

        IWorldMap map = new GrassField(grasses);
        Animal jaksolka = new Animal(map);
        map.place(jaksolka);
        assertEquals(map.objectAt(new Vector2d(2,2)).toString(), jaksolka.toString());
        assertEquals(map.objectAt(new Vector2d(2,0)).toString(), new Grass(new Vector2d(2, 0)).toString());
    }
}