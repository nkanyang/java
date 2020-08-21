package com.codetest.toyrobot.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {
    private static final Robot robot = new Robot();
    private static final Position originPosition = new Position(1, 1);
    private static final Direction originDirection = Direction.NORTH;

    @BeforeEach
    public void placeRobot() {
        robot.setPlace(originPosition, originDirection);
    }

    @Test
    public void testSetPlace_whenPlaceRobot_thenMoveToNewPosition() {
        Position newPosition = new Position(2, 2);
        robot.setPlace(newPosition, Direction.SOUTH);
        assertEquals(Direction.SOUTH, robot.getDirection());
        assertEquals(newPosition, robot.getPosition());
    }

    @Test
    public void testTurnLeft_whenRobotPlaced_thenTurnLeft() {
        robot.turnLeft();
        assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    public void testTurnRight_whenRobotPlaced_thenTurnRight() {
        robot.turnRight();
        assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    public void testMoveTo_whenRobotPlaced_thenMoveToNewPositionKeepSameDirection() {
        Position newPosition = new Position(2, 2);
        robot.moveTo(newPosition);
        assertEquals(originDirection, robot.getDirection());
        assertEquals(newPosition, robot.getPosition());
    }

    @Test
    public void testReportPosition_whenRobotPlaced_thenReturnString() {
        robot.reportPosition();
        assertEquals("1,1,NORTH", robot.reportPosition());
    }

    @Test
    public void testIsOnBoard_whenRobotPlaced_thenReturnTrue() {
        assertEquals(true, robot.isOnBoard());
    }

    @Test
    public void testIsOnBoard_whenRobotNot_thenReturnFalse() {
        Robot newRobot = new Robot();
        assertEquals(false, newRobot.isOnBoard());
    }

    @Test
    public void testGetPosition_whenRobotPlaced_thenReturnPosition() {
        assertEquals(originDirection, robot.getDirection());
    }

    @Test
    public void testGetDirection_whenRobotPlaced_thenReturnDirection() {
        assertEquals(originPosition, robot.getPosition());
    }

    @Nested
    public class GetNextPositionTest {
        @Test
        public void testGetNextPosition_whenFacingNorth_thenOnlyIncreaseY() {
            Position initPosition = new Position(1, 1);
            robot.setPlace(initPosition, Direction.NORTH);
            Position newPosition = robot.getNextPosition();
            assertEquals(initPosition.getX(), newPosition.getX());
            assertEquals(initPosition.getY() + 1, newPosition.getY());
        }

        @Test
        public void testGetNextPosition_whenFacingEast_thenOnlyIncreaseX() {
            Position initPosition = new Position(1, 1);
            robot.setPlace(initPosition, Direction.EAST);
            Position newPosition = robot.getNextPosition();
            assertEquals(initPosition.getX() + 1, newPosition.getX());
            assertEquals(initPosition.getY(), newPosition.getY());
        }

        @Test
        public void testGetNextPosition_whenFacingSouth_thenOnlyDecreaseY() {
            Position initPosition = new Position(1, 1);
            robot.setPlace(initPosition, Direction.SOUTH);
            Position newPosition = robot.getNextPosition();
            assertEquals(initPosition.getX(), newPosition.getX());
            assertEquals(initPosition.getY() - 1, newPosition.getY());
        }

        @Test
        public void testGetNextPosition_whenFacingWest_thenOnlyDecreaseX() {
            Position initPosition = new Position(1, 1);
            robot.setPlace(initPosition, Direction.WEST);
            Position newPosition = robot.getNextPosition();
            assertEquals(initPosition.getX() - 1, newPosition.getX());
            assertEquals(initPosition.getY(), newPosition.getY());
        }
    }
}
