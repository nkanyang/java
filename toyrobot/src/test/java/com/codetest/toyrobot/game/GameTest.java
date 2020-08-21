package com.codetest.toyrobot.game;

import com.codetest.toyrobot.commands.MoveCommand;
import com.codetest.toyrobot.commands.PlaceCommand;
import com.codetest.toyrobot.commands.ReportCommand;
import org.apache.log4j.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        Game.logger.setLevel(Level.OFF);
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setOut(systemOut);
    }

    @Test
    public void testExecuteCommand_whenSucceed_thenLogInfo() {
        Game game = new Game(5, 5);
        game.executeCommand(new PlaceCommand(new Position(1, 1), Direction.NORTH));
        game.executeCommand(new ReportCommand());
        assertEquals("1,1,NORTH\n", testOut.toString());
    }

    @Test
    public void testExecuteCommand_whenPlaceOutOfBoard_thenIgnoreCommand() {
        Game game = new Game(5, 5);
        game.executeCommand(new PlaceCommand(new Position(7, 9), Direction.WEST));
        game.executeCommand(new ReportCommand());
        assertEquals("", testOut.toString());
    }

    @Test
    public void testExecuteCommand_whenMoveOutOfBoard_thenIgnoreCommand() {
        Game game = new Game(5, 5);
        game.executeCommand(new PlaceCommand(new Position(0, 1), Direction.WEST));
        game.executeCommand(new MoveCommand());
        game.executeCommand(new ReportCommand());
        assertEquals("0,1,WEST\n", testOut.toString());
    }

    @Test
    public void testExecuteCommand_whenNotPlaceRobot_thenIgnoreCommand() {
        Game game = new Game(5, 5);
        game.executeCommand(new MoveCommand());
        game.executeCommand(new ReportCommand());
        assertEquals("", testOut.toString());
    }

}
