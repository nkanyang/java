package com.codetest.toyrobot.commands;

import com.codetest.toyrobot.exceptions.RobotNotOnBoardException;
import com.codetest.toyrobot.game.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LeftCommandTest {
    private static final LeftCommand command = new LeftCommand();

    @Test
    public void testExecute_whenRobotNotOnboard_thenThrowException() {
        Robot mockRobot = mock(Robot.class);
        when(mockRobot.isOnBoard()).thenReturn(false);
        assertThrows(RobotNotOnBoardException.class,
                () -> command.execute(mockRobot, null));
    }

    @Test
    public void testExecute_whenRobotOnboard_thenRobotTurnLeft() {
        Robot mockRobot = mock(Robot.class);
        doNothing().when(mockRobot).turnLeft();
        when(mockRobot.isOnBoard()).thenReturn(true);

        assertDoesNotThrow(() -> command.execute(mockRobot, null));
        verify(mockRobot, times(1)).turnLeft();
    }

    @Test
    public void testToString_thenOk() {
        assertEquals("LEFT", command.toString());
    }
}
