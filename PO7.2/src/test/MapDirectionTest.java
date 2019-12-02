package test;

import org.junit.Test;

import static agh.cs.po.lab7.MapDirection.*;
import static org.junit.Assert.assertEquals;

public class MapDirectionTest {
    @Test
    public void next() {
        assertEquals(NORTH, WEST.next());
        assertEquals(SOUTH, EAST.next());
        assertEquals(WEST, SOUTH.next());
        assertEquals(EAST, NORTH.next());
    }

    @Test
    public void previous() {
        assertEquals(NORTH, EAST.previous());
        assertEquals(SOUTH, WEST.previous());
        assertEquals(WEST, NORTH.previous());
        assertEquals(EAST, SOUTH.previous());
    }
}
