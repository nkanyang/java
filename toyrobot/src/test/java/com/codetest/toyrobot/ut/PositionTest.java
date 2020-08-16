package com.codetest.toyrobot.ut;

import com.codetest.toyrobot.game.Direction;
import com.codetest.toyrobot.game.Position;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PositionTest {

    @Test
    public void testToString_returnPositionString(){
        Direction mockDirection = mock(Direction.class);
        when(mockDirection.toString()).thenReturn("NORTH");
        Position position = new Position(1,1, Direction.NORTH);
        assertEquals("1,1,NORTH", position.toString());
    }

    @Test
    public void testGetX_returnX(){
        int x = 1;
        int y = 1;
        Position position = new Position(x,y, Direction.NORTH);
        assertEquals(x, position.getX());
    }

    @Test
    public void testGetY_returnY(){
        int x = 1;
        int y = 1;
        Position position = new Position(x,y, Direction.NORTH);
        assertEquals(y, position.getY());
    }

    @Test
    public void testGetDirection_returnDirection(){
        Direction mockDirection = mock(Direction.class);
        when(mockDirection.getDirection()).thenReturn(Direction.NORTH);
        Position position = new Position(1,1, Direction.NORTH);

        Direction resultDirection = position.getDirection();
        assertEquals(Direction.NORTH, resultDirection.getDirection());
    }

    @Nested
    class TestGetNextPosition{
        @Test
        public void testGetNextPosition_whenFacingNorth_thenOnlyIncreaseY(){
            int x = 1;
            int y = 1;
            Position position = new Position(1,1, Direction.NORTH);
            Position newPosition = position.getNextPosition();
            assertEquals(x, newPosition.getX());
            assertEquals(y + 1, newPosition.getY());
        }

        @Test
        public void testGetNextPosition_whenFacingEast_thenOnlyIncreaseX(){
            int x = 1;
            int y = 1;
            Position position = new Position(1,1, Direction.EAST);
            Position newPosition = position.getNextPosition();
            assertEquals(x + 1, newPosition.getX());
            assertEquals(y, newPosition.getY());
        }

        @Test
        public void testGetNextPosition_whenFacingSouth_thenOnlyDecreaseY(){
            int x = 1;
            int y = 1;
            Position position = new Position(1,1, Direction.SOUTH);
            Position newPosition = position.getNextPosition();
            assertEquals(x, newPosition.getX());
            assertEquals(y - 1, newPosition.getY());
        }

        @Test
        public void testGetNextPosition_whenFacingWest_thenOnlyDecreaseX(){
            int x = 1;
            int y = 1;
            Position position = new Position(1,1, Direction.WEST);
            Position newPosition = position.getNextPosition();
            assertEquals(x - 1, newPosition.getX());
            assertEquals(y, newPosition.getY());
        }
    }
}
