package test;

import agh.cs.po.lab7.MapDirection;
import agh.cs.po.lab7.MoveDirection;
import agh.cs.po.lab7.Animal;
import agh.cs.po.lab7.IWorldMap;
import agh.cs.po.lab7.RectangularMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void move() {
        IWorldMap map = new RectangularMap(10, 5);
        Animal jaskolka = new Animal(map);
        map.place(jaskolka);

        jaskolka.move(MoveDirection.RIGHT);
        assertEquals(jaskolka.getMapDirection(), MapDirection.EAST);
        jaskolka.move(MoveDirection.RIGHT);
        assertEquals(jaskolka.getMapDirection(), MapDirection.SOUTH);
        jaskolka.move(MoveDirection.RIGHT);
        assertEquals(jaskolka.getMapDirection(), MapDirection.WEST);
        jaskolka.move(MoveDirection.RIGHT);
        assertEquals(jaskolka.getMapDirection(), MapDirection.NORTH);

        jaskolka.move(MoveDirection.LEFT);
        assertEquals(jaskolka.getMapDirection(), MapDirection.WEST);
        jaskolka.move(MoveDirection.LEFT);
        assertEquals(jaskolka.getMapDirection(), MapDirection.SOUTH);
        jaskolka.move(MoveDirection.LEFT);
        assertEquals(jaskolka.getMapDirection(), MapDirection.EAST);
        jaskolka.move(MoveDirection.LEFT);
        assertEquals(jaskolka.getMapDirection(), MapDirection.NORTH);

        int i = 0;
        while(i<10) {
            jaskolka.move(MoveDirection.FORWARD);
            i++;
        }

        assertEquals(jaskolka.getPosition().getX(), 2);
        assertEquals(jaskolka.getPosition().getY(), 4);

        i = 0;
        while(i<10) {
            jaskolka.move(MoveDirection.BACKWARD);
            i++;
        }

        assertEquals(jaskolka.getPosition().getX(), 2);
        assertEquals(jaskolka.getPosition().getY(), 0);
    }
}