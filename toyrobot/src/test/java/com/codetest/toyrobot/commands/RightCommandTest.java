package com.codetest.toyrobot.commands;

import com.codetest.toyrobot.exceptions.RobotNotOnBoardException;
import com.codetest.toyrobot.game.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RightCommandTest {
    private static final RightCommand command = new RightCommand();

    @Test
    public void testExecute_whenRobotNotOnboard_thenThrowException() {
        Robot mockRobot = mock(Robot.class);
        when(mockRobot.isOnBoard()).thenReturn(false);
        assertThrows(RobotNotOnBoardException.class,
                () -> command.execute(mockRobot, null));
    }

    @Test
    public void testExecute_whenRobotOnboard_thenRobotTurnRight() {
        Robot mockRobot = mock(Robot.class);
        doNothing().when(mockRobot).turnRight();
        when(mockRobot.isOnBoard()).thenReturn(true);

        assertDoesNotThrow(() -> command.execute(mockRobot, null));
        verify(mockRobot, times(1)).turnRight();
    }

    @Test
    public void testToString_thenOk() {
        assertEquals("RIGHT", command.toString());
    }
}
