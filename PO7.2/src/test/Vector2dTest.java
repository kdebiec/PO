package test;

import org.junit.Test;

import agh.cs.po.lab7.Vector2d;
import static org.junit.Assert.*;

public class Vector2dTest {
    @Test
    public void testToString() {
        Vector2d vec = new Vector2d(1, 2);
        assertEquals(vec.toString(),"("+vec.getX()+","+vec.getY()+")");
    }

    @Test
    public void precedes() {
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(-2, 1);
        assertEquals(vec1.precedes(vec2), false);
    }

    @Test
    public void follows() {
        Vector2d vec1 = new Vector2d(2,3);
        Vector2d vec2 =new Vector2d(1,2);
        assertTrue(vec1.follows(vec2));
    }

    @Test
    public void upperRight() {
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 =new Vector2d(2,3);
        Vector2d upper = new Vector2d(Math.max(vec1.getX(), vec2.getX()), Math.max(vec1.getY(), vec2.getY()));
        assertEquals(vec1.upperRight(vec2), upper );
    }

    @Test
    public void lowerLeft() {
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 =new Vector2d(2,3);
        Vector2d lower = new Vector2d(Math.min(vec1.getX(), vec2.getX()), Math.min(vec1.getY(), vec2.getY()));
        assertEquals(vec1.lowerLeft(vec2), lower );
    }

    @Test
    public void add() {
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 =new Vector2d(2,3);
        Vector2d sum = new Vector2d(vec1.getX() + vec2.getX(), vec1.getY() +vec2.getY());
        assertEquals(vec1.add(vec2), sum);
    }

    @Test
    public void subtract() {
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 =new Vector2d(2,3);
        Vector2d diff = new Vector2d(vec1.getX() - vec2.getX(), vec1.getY()-vec2.getY());
        assertEquals(vec1.subtract(vec2), diff );
    }

    @Test
    public void testEquals() {
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 =new Vector2d(2,3);
        assertFalse(vec1.equals(vec2));
    }

    @Test
    public void opposite() {
        Vector2d vec1 = new Vector2d(1,2);
        Vector2d vec2 = new Vector2d(-vec1.getX(),-vec1.getY());

        assertEquals(vec1.opposite(),  vec2);
    }
}