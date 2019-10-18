package agh.cs.lab2;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class Vector2dTest {
    Vector2d v_1_1 = new Vector2d(1, 1);
    Vector2d v_1_1_b = new Vector2d(1, 1);
    Vector2d v_1_2 = new Vector2d(1, 2);
    Vector2d v_0_0 = new Vector2d(0, 0);
    Vector2d v_0_1 = new Vector2d(0, 1);
    Vector2d v_2_1 = new Vector2d(2, 1);
    Vector2d v_1_0 = new Vector2d(1, 0);
    Vector2d v_2_2 = new Vector2d(2, 2);
    Vector2d v_m1_m1 = new Vector2d(-1, -1);


    @Test
    public void testEquals() {
        assertTrue(v_1_1.equals(v_1_1_b));
        assertFalse(v_1_1.equals(v_1_2));

    }

    @Test
    public void testToString() {
        assertTrue("(1,1)".equals(v_1_1.toString()));
    }

    @Test
    public void testPrecedes() {
        assertTrue(v_0_0.precedes(v_1_1));
        assertTrue(v_1_1.precedes(v_1_1_b));
        assertTrue(v_1_0.precedes(v_1_1));
        assertTrue(v_0_1.precedes(v_1_1));
        assertFalse(v_2_2.precedes(v_1_1));
    }

    @Test
    public void testFollows() {
        assertTrue(v_1_1.follows(v_0_0));
        assertTrue(v_1_1.follows(v_1_1_b));
        assertTrue(v_1_2.follows(v_1_1));
        assertTrue(v_2_1.follows(v_1_1));
        assertFalse(v_1_1.follows(v_2_2));
    }

    @Test
    public void testUpperRight() {
        assertTrue(v_1_1.upperRight(v_2_2).equals(v_2_2));
        assertTrue(v_1_1.upperRight(v_1_0).equals(v_1_1));
        assertTrue(v_0_1.upperRight(v_1_0).equals(v_1_1));
        assertFalse(v_0_1.upperRight(v_1_0).equals(v_0_0));
    }

    @Test
    public void testLowerLeft() {
        assertTrue(v_1_1.lowerLeft(v_2_2).equals(v_1_1));
        assertTrue(v_1_1.lowerLeft(v_1_0).equals(v_1_0));
        assertTrue(v_0_1.lowerLeft(v_1_0).equals(v_0_0));
        assertFalse(v_0_1.lowerLeft(v_1_0).equals(v_1_1));
    }

    @Test
    public void testAdd() {
        assertTrue(v_1_1.add(v_0_0).equals(v_1_1));
        assertTrue(v_1_0.add(v_0_1).equals(v_1_1));
        assertTrue(v_1_1.add(v_0_1).equals(v_1_2));
        assertFalse(v_1_1.add(v_1_1).equals(v_0_0));
    }

    @Test
    public void testSubtract() {
        assertTrue(v_1_1.subtract(v_0_0).equals(v_1_1));
        assertTrue(v_1_1.subtract(v_0_1).equals(v_1_0));
        assertTrue(v_2_2.subtract(v_1_0).equals(v_1_2));
        assertFalse(v_1_1.subtract(v_1_1).equals(v_2_2));
    }

    @Test
    public void testOpposite() {
        assertTrue(v_1_1.opposite().equals(v_m1_m1));
        assertTrue(v_m1_m1.opposite().equals(v_1_1));
        assertTrue(v_0_0.opposite().equals(v_0_0));
        assertFalse(v_0_1.opposite().equals(v_1_0));
    }
}
