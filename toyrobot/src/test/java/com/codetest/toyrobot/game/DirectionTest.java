package com.codetest.toyrobot.game;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {

    @Nested
    class TestGetLeft {
        @Test
        public void testGetLeft_whenFacingNorth_thenFacingWest() {
            Direction direction = Direction.NORTH;
            Direction result = direction.getLeft();
            assertEquals("WEST", result.toString());
        }

        @Test
        public void testGetLeft_whenFacingWest_thenFacingSouth() {
            Direction direction = Direction.WEST;
            Direction result = direction.getLeft();
            assertEquals("SOUTH", result.toString());
        }

        @Test
        public void testGetLeft_whenFacingSouth_thenFacingEast() {
            Direction direction = Direction.SOUTH;
            Direction result = direction.getLeft();
            assertEquals("EAST", result.toString());
        }

        @Test
        public void testGetLeft_whenFacingEast_thenFacingNorth() {
            Direction direction = Direction.EAST;
            Direction result = direction.getLeft();
            assertEquals("NORTH", result.toString());
        }
    }

    @Nested
    class TestGetRight {
        @Test
        public void testGetRight_whenFacingEast_thenFacingSouth() {
            Direction direction = Direction.EAST;
            Direction result = direction.getRight();
            assertEquals("SOUTH", result.toString());
        }

        @Test
        public void testGetRight_whenFacingSouth_thenFacingWest() {
            Direction direction = Direction.SOUTH;
            Direction result = direction.getRight();
            assertEquals("WEST", result.toString());
        }

        @Test
        public void testGetRight_whenFacingWest_thenFacingNorth() {
            Direction direction = Direction.WEST;
            Direction result = direction.getRight();
            assertEquals("NORTH", result.toString());
        }

        @Test
        public void testGetRight_whenFacingNorth_thenFacingEast() {
            Direction direction = Direction.NORTH;
            Direction result = direction.getRight();
            assertEquals("EAST", result.toString());
        }
    }
}
