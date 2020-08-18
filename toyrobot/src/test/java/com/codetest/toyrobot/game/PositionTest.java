package com.codetest.toyrobot.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    public void testGetX_returnX(){
        int x = 1;
        int y = 1;
        Position position = new Position(x,y);
        assertEquals(x, position.getX());
    }

    @Test
    public void testGetY_returnY(){
        int x = 1;
        int y = 1;
        Position position = new Position(x,y);
        assertEquals(y, position.getY());
    }
}

