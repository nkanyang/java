package com.codetest.toyrobot.ut;

import com.codetest.toyrobot.logger.RobotLogger;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RobotLoggerTest {

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setOut(systemOut);
    }

    @Test
    public void testPrint_whenEnableDetails_thenPrint() {
        String testMessage = "test";
        RobotLogger.enableDetails();
        RobotLogger.print(testMessage);
        assertEquals(testMessage + "\n", testOut.toString());
    }

    @Test
    public void testPrint_whenDisableDetails_thenReturn() {
        String testMessage = "test";
        RobotLogger.disableDetails();
        RobotLogger.print(testMessage);
        assertEquals("", testOut.toString());
    }

    @Test
    public void testPrintPositionOutOfField_whenIsDetailedTrue_thenPrintMessage() {
        RobotLogger.enableDetails();
        RobotLogger.printPositionOutOfField();
        assertEquals(
                "Position out of board. Command ignored!\n",
                testOut.toString());
    }

    @Test
    public void testPrintRobotNotOnBoard_whenIsDetailedTrue_thenPrintMessage() {
        RobotLogger.enableDetails();
        RobotLogger.printRobotNotOnBoard();
        assertEquals(
                "No robot on board. Command ignored!\n",
                testOut.toString());
    }
}
