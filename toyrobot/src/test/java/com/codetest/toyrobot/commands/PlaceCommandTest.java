package com.codetest.toyrobot.commands;

import com.codetest.toyrobot.exceptions.InvalidPositionException;
import com.codetest.toyrobot.game.Board;
import com.codetest.toyrobot.game.Direction;
import com.codetest.toyrobot.game.Position;
import com.codetest.toyrobot.game.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlaceCommandTest {
    private static final Position position = new Position(0, 0);
    private static final PlaceCommand command = new PlaceCommand(position, Direction.NORTH);

    @Test
    public void testExecute_whenPositionNotOnboard_thenThrowException() {
        Robot mockRobot = mock(Robot.class);
        Board mockBoard = mock(Board.class);
        when(mockBoard.isValidPosition(position)).thenReturn(false);

        assertThrows(InvalidPositionException.class,
                () -> command.execute(mockRobot, mockBoard));
    }

    @Test
    public void testExecute_whenPositionOnboard_thenRobotSetPlace() {
        Robot mockRobot = mock(Robot.class);
        Board mockBoard = mock(Board.class);
        doNothing().when(mockRobot).setPlace(position, Direction.NORTH);
        when(mockBoard.isValidPosition(position)).thenReturn(true);

        assertDoesNotThrow(() -> command.execute(mockRobot, mockBoard));
        verify(mockRobot, times(1)).setPlace(position, Direction.NORTH);
    }

    @Test
    public void testToString_thenOk() {
        assertEquals("PLACE 0,0,NORTH", command.toString());
    }
}