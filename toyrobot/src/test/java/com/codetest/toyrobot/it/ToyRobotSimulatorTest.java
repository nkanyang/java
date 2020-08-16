package com.codetest.toyrobot.it;

import com.codetest.toyrobot.ToyRobotSimulator;
import com.codetest.toyrobot.logger.RobotLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class ToyRobotSimulatorTest {
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;
    private final String path = System.getProperty("user.dir") + "/src/test/resources/";

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        RobotLogger.disableDetails();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setOut(systemOut);
    }

    @Test
    public void testMain_file1(){
        String fileName = this.path + "test1.txt";
        ToyRobotSimulator.main(new String[]{fileName});
        assertEquals("0,1,NORTH\n", testOut.toString());
    }
    @Test
    public void testMain_file2(){
        String fileName = this.path + "test2.txt";
        ToyRobotSimulator.main(new String[]{fileName});
        assertEquals("0,0,WEST\n", testOut.toString());
    }
    @Test
    public void testMain_file3(){
        String fileName = this.path + "test3.txt";
        ToyRobotSimulator.main(new String[]{fileName});
        assertEquals("3,3,NORTH\n", testOut.toString());
    }

}
