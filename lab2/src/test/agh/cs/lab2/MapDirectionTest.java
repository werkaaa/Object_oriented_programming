package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MapDirectionTest {

    @Test
    public void testNext() {
        assertTrue(MapDirection.EAST.equals(MapDirection.NORTH.next()));
        assertTrue(MapDirection.SOUTH.equals(MapDirection.EAST.next()));
        assertTrue(MapDirection.WEST.equals(MapDirection.SOUTH.next()));
        assertTrue(MapDirection.NORTH.equals(MapDirection.WEST.next()));
    }

    @Test
    public void testPrevious() {
        assertTrue(MapDirection.NORTH.equals(MapDirection.EAST.previous()));
        assertTrue(MapDirection.EAST.equals(MapDirection.SOUTH.previous()));
        assertTrue(MapDirection.SOUTH.equals(MapDirection.WEST.previous()));
        assertTrue(MapDirection.WEST.equals(MapDirection.NORTH.previous()));
    }


}
