package com.codetest.toyrobot.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    public void testGetX_returnX() {
        int x = 1;
        int y = 1;
        Position position = new Position(x, y);
        assertEquals(x, position.getX());
    }

    @Test
    public void testGetY_returnY() {
        int x = 1;
        int y = 1;
        Position position = new Position(x, y);
        assertEquals(y, position.getY());
    }

    @Test
    public void testGetNewPosition_returnNewPosition() {
        Position current = new Position(3,2);
        Position offset = new Position(1,-1);
        Position newPosition = current.getNewPosition(offset);
        assertEquals(4, newPosition.getX());
        assertEquals(1, newPosition.getY());
    }
}

