package com.codetest.toyrobot.it;

import com.codetest.toyrobot.command.Command;
import com.codetest.toyrobot.game.Game;
import com.codetest.toyrobot.logger.RobotLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ToyRobotGameTest {
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

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

    @Nested
    public class TestBeforeInitialized{
        @Test
        public void it_whenPlaceNotExecute_thenGameNotInitialized(){
            Command[] commands = {
                    Command.parseAndBuild("MOVE"),
                    Command.parseAndBuild("LEFT"),
                    Command.parseAndBuild("RIGHT"),
                    Command.parseAndBuild("REPORT"),
            };
            Game game = new Game(5,5);
            for(Command c : commands){
                game.executeCommand(c);
            }
            assertEquals(false, game.isRobotInitialized());
            assertEquals("There is no robot on the board.\n", testOut.toString());
        }

        @Test
        public void it_whenPlaceRobotOufOfBoard_thenGameNotInitialized(){
            Command[] commands = {
                    Command.parseAndBuild("PLACE 5,5,NORTH"),
            };
            Game game = new Game(5,5);
            for(Command c : commands){
                game.executeCommand(c);
            }
            assertEquals(false, game.isRobotInitialized());
        }
    }


    @Nested
    public class TestAfterInitialized{
        @Test
        public void it_whenPlaceRobotOnBoard_thenRobotInitialized(){
            Command[] commands = {
                    Command.parseAndBuild("PLACE 0,0,NORTH"),
                    Command.parseAndBuild("REPORT")
            };
            Game game = new Game(5,5);
            for(Command c : commands){
                game.executeCommand(c);
            }
            assertEquals(true, game.isRobotInitialized());
            assertEquals("0,0,NORTH\n", testOut.toString());
        }

        @Test
        public void it_whenPlaceRobotAgain_thenRobotMoveToNewPosition(){
            Command[] commands = {
                    Command.parseAndBuild("PLACE 0,0,NORTH"),
                    Command.parseAndBuild("PLACE 3,2,EAST"),
                    Command.parseAndBuild("REPORT")
            };
            Game game = new Game(5,5);
            for(Command c : commands){
                game.executeCommand(c);
            }
            assertEquals(true, game.isRobotInitialized());
            assertEquals("3,2,EAST\n", testOut.toString());
        }

        @Test
        public void it_whenNextMoveFall_thenIgnoreMove(){
            Command[] commands = {
                    Command.parseAndBuild("PLACE 0,0,WEST"),
                    Command.parseAndBuild("MOVE"),
                    Command.parseAndBuild("REPORT")
            };
            Game game = new Game(5,5);
            for(Command c : commands){
                game.executeCommand(c);
            }
            assertEquals("0,0,WEST\n", testOut.toString());
        }

        @Test
        public void it_whenCommandMoveAndWillNotFall_thenOneStepForwardOnItsDirection(){
            Command[] commands = {
                    Command.parseAndBuild("PLACE 0,0,NORTH"),
                    Command.parseAndBuild("MOVE"),
                    Command.parseAndBuild("REPORT")
            };
            Game game = new Game(5,5);
            for(Command c : commands){
                game.executeCommand(c);
            }
            assertEquals("0,1,NORTH\n", testOut.toString());
        }

        @Test
        public void it_whenCommandLeft_thenChangeDirectionToItsLeft(){
            Command[] commands = {
                    Command.parseAndBuild("PLACE 0,0,WEST"),
                    Command.parseAndBuild("LEFT"),
                    Command.parseAndBuild("REPORT")
            };
            Game game = new Game(5,5);

            for(Command c : commands){
                game.executeCommand(c);
            }

            assertEquals("0,0,SOUTH\n", testOut.toString());
        }

        @Test
        public void it_whenCommandRight_thenChangeDirectionToItsRight(){
            Command[] commands = {
                    Command.parseAndBuild("PLACE 0,0,WEST"),
                    Command.parseAndBuild("RIGHT"),
                    Command.parseAndBuild("REPORT")
            };
            Game game = new Game(5,5);

            for(Command c : commands){
                game.executeCommand(c);
            }

            assertEquals("0,0,NORTH\n", testOut.toString());
        }
    }


}
