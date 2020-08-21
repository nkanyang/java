package com.codetest.toyrobot.commands;

import com.codetest.toyrobot.exceptions.InvalidPositionException;
import com.codetest.toyrobot.exceptions.RobotNotOnBoardException;
import com.codetest.toyrobot.game.Board;
import com.codetest.toyrobot.game.Position;
import com.codetest.toyrobot.game.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MoveCommandTest {
    private static final MoveCommand command = new MoveCommand();

    @Test
    public void testExecute_whenRobotNotOnboard_thenThrowException() {
        Robot mockRobot = mock(Robot.class);
        when(mockRobot.isOnBoard()).thenReturn(false);
        assertThrows(RobotNotOnBoardException.class,
                () -> command.execute(mockRobot, null));
    }

    @Test
    public void testExecute_whenRobotOnboardAndWillFall_thenThrowException() {
        Robot mockRobot = mock(Robot.class);
        Board mockBoard = mock(Board.class);
        Position position = new Position(0, 0);
        when(mockRobot.isOnBoard()).thenReturn(true);
        when(mockRobot.getNextPosition()).thenReturn(position);
        when(mockBoard.isValidPosition(position)).thenReturn(false);

        assertThrows(InvalidPositionException.class,
                () -> command.execute(mockRobot, mockBoard));
    }

    @Test
    public void testExecute_whenRobotOnboardAndWillNotFall_thenRobotMove() {
        Robot mockRobot = mock(Robot.class);
        Board mockBoard = mock(Board.class);
        Position position = new Position(0, 0);
        doNothing().when(mockRobot).moveTo(position);
        when(mockRobot.isOnBoard()).thenReturn(true);
        when(mockRobot.getNextPosition()).thenReturn(position);
        when(mockBoard.isValidPosition(position)).thenReturn(true);

        assertDoesNotThrow(() -> command.execute(mockRobot, mockBoard));
        verify(mockRobot, times(1)).moveTo(position);
    }

    @Test
    public void testToString_thenOk() {
        assertEquals("MOVE", command.toString());
    }
}
