package com.codetest.toyrobot.ut;

import com.codetest.toyrobot.game.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {
    @Test
    public void testGetDirection_whenFacingNorth_thenReturnNorth(){
        Assertions.assertEquals(Direction.NORTH, new Direction(Direction.NORTH).getDirection());
    }

    @Nested
    class TestTurnLeft{
        @Test
        public void testTurnLeft_whenFacingNorth_thenFacingWest(){
            Direction direction= new Direction(Direction.NORTH);
            direction.turnLeft();
            assertEquals(Direction.WEST, direction.getDirection());
        }

        @Test
        public void testTurnLeft_whenFacingWest_thenFacingSouth(){
            Direction direction= new Direction(Direction.WEST);
            direction.turnLeft();
            assertEquals(Direction.SOUTH, direction.getDirection());
        }

        @Test
        public void testTurnLeft_whenFacingSouth_thenFacingEast(){
            Direction direction= new Direction(Direction.SOUTH);
            direction.turnLeft();
            assertEquals(Direction.EAST, direction.getDirection());
        }

        @Test
        public void testTurnLeft_whenFacingEast_thenFacingNorth(){
            Direction direction= new Direction(Direction.EAST);
            direction.turnLeft();
            assertEquals(Direction.NORTH, direction.getDirection());
        }
    }

    @Nested
    class TestTurnRight{
        @Test
        public void testTurnRight_whenFacingEast_thenFacingSouth(){
            Direction direction= new Direction(Direction.EAST);
            direction.turnRight();
            assertEquals(Direction.SOUTH, direction.getDirection());
        }

        @Test
        public void testTurnRight_whenFacingSouth_thenFacingWest(){
            Direction direction= new Direction(Direction.SOUTH);
            direction.turnRight();
            assertEquals(Direction.WEST, direction.getDirection());
        }

        @Test
        public void testTurnRight_whenFacingWest_thenFacingNorth(){
            Direction direction= new Direction(Direction.WEST);
            direction.turnRight();
            assertEquals(Direction.NORTH, direction.getDirection());
        }

        @Test
        public void testTurnRight_whenFacingNorth_thenFacingEast(){
            Direction direction= new Direction(Direction.NORTH);
            direction.turnRight();
            assertEquals(Direction.EAST, direction.getDirection());
        }
    }

    @Test
    public void testToString_whenFacingSouth_thenReturnStringSOUTH(){
        Direction direction= new Direction(Direction.SOUTH);
        assertEquals("SOUTH", direction.toString());
    }
}
