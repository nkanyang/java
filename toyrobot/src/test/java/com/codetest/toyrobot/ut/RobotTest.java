package com.codetest.toyrobot.ut;

import com.codetest.toyrobot.game.Direction;
import com.codetest.toyrobot.game.Position;
import com.codetest.toyrobot.game.Robot;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RobotTest {

    @Test
    public void testTurnLeft_whenCalled_thenCallDirectionTurnLeft(){
        Position mockPosition = mock(Position.class);
        Direction mockDirection = mock(Direction.class);
        when(mockPosition.getDirection()).thenReturn(mockDirection);
        doNothing().when(mockDirection).turnLeft();
        Robot robot = new Robot(mockPosition);

        robot.turnLeft();
        verify(mockPosition, times(1)).getDirection();
        verify(mockDirection, times(1)).turnLeft();
    }

    @Test
    public void testTurnRight_whenCalled_thenCallDirectionTurnRight(){
        Position mockPosition = mock(Position.class);
        Direction mockDirection = mock(Direction.class);
        when(mockPosition.getDirection()).thenReturn(mockDirection);
        doNothing().when(mockDirection).turnLeft();
        Robot robot = new Robot(mockPosition);

        robot.turnRight();
        verify(mockPosition, times(1)).getDirection();
        verify(mockDirection, times(1)).turnRight();
    }

    @Test
    public void testMoveTo_whenCalled_thenPositionUpdate(){
        Position newPosition = new Position(1,2,Direction.NORTH);
        Position oldPosition = new Position(1,1,Direction.NORTH);
        Robot robot = new Robot(oldPosition);

        robot.moveTo(newPosition);
        assertEquals(newPosition.getX(), robot.reportPosition().getX());
        assertEquals(newPosition.getY(), robot.reportPosition().getY());
    }

    @Test
    public void testReportPosition_whenCalled_thenReturnPosition(){
        Position position = new Position(1,2,Direction.NORTH);
        Robot robot = new Robot(position);

        Position result = robot.reportPosition();
        assertEquals(position.getX(), result.getX());
        assertEquals(position.getY(), result.getY());
        assertEquals(position.getDirection(), result.getDirection());
    }

    @Test
    public void testGetNextPosition_whenCalled_thenReturnNextPosition(){
        Position mockPosition = mock(Position.class);
        when(mockPosition.getNextPosition()).thenReturn(new Position(1,2,Direction.NORTH));
        Robot robot = new Robot(mockPosition);

        Position result = robot.getNextPosition();
        verify(mockPosition,times(1)).getNextPosition();
    }

}
