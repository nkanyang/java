package com.codetest.toyrobot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToyRobotSimulatorTest {
    private final PrintStream systemOut = System.out;
    private final String path = System.getProperty("user.dir") + "/src/test/resources/";
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
    public void testToyRobotSimulator_whenMoveAfterPlace_thenOk() {
        String fileName = this.path + "test1.txt";
        ToyRobotSimulator.main(new String[]{fileName});
        assertEquals("0,1,NORTH\n", testOut.toString());
    }

    @Test
    public void testToyRobotSimulator_whenTurnLeftAfterPlace_thenOk() {
        String fileName = this.path + "test2.txt";
        ToyRobotSimulator.main(new String[]{fileName});
    }

    @Test
    public void testToyRobotSimulator_whenSeriesOfCommandExecuteAfterPlace_thenOk() {
        String fileName = this.path + "test3.txt";
        ToyRobotSimulator.main(new String[]{fileName});
        assertEquals("3,3,NORTH\n", testOut.toString());
    }
}
