package com.codetest.toyrobot.commands;

import com.codetest.toyrobot.exceptions.RobotNotOnBoardException;
import com.codetest.toyrobot.game.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReportCommandTest {
    private static final ReportCommand command = new ReportCommand();

    @Test
    public void testExecute_whenRobotNotOnboard_thenThrowException() {
        Robot mockRobot = mock(Robot.class);
        when(mockRobot.isOnBoard()).thenReturn(false);
        assertThrows(RobotNotOnBoardException.class,
                () -> command.execute(mockRobot, null));
    }

    @Test
    public void testExecute_whenRobotOnboard_thenRobotReport() {
        Robot mockRobot = mock(Robot.class);
        when(mockRobot.isOnBoard()).thenReturn(true);
        when(mockRobot.reportPosition()).thenReturn("0,0,NORTH");

        assertDoesNotThrow(() -> command.execute(mockRobot, null));
        verify(mockRobot, times(1)).reportPosition();
    }

    @Test
    public void testToString_thenOk() {
        assertEquals("REPORT", command.toString());
    }
}
