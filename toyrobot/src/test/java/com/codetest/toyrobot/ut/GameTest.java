package com.codetest.toyrobot.ut;

import com.codetest.toyrobot.command.Command;
import com.codetest.toyrobot.game.Direction;
import com.codetest.toyrobot.game.Game;
import com.codetest.toyrobot.game.Position;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Nested
    public class TestIsRobotInitialized{
        @Test
        public void testIsRobotInitialized_whenGameNewlyCreated_thenReturnFalse(){
            Game game = new Game(5,5);
            assertEquals(false, game.isRobotInitialized());
        }

        @Test
        public void testIsRobotInitialized_whenPlaced_thenReturnTrue(){
            Game game = new Game(5,5);
            Position position = new Position(2,2, Direction.WEST);
            game.placeRobot(position);
            assertEquals(true, game.isRobotInitialized());
        }
    }

    @Nested
    public class TestExecuteCommand{
        @Test
        public void testExecuteCommand_whenPlace_thenOK(){
            Command command = Command.parseAndBuild("PLACE 1,1,NORTH");
            Game game = new Game(5,5);
            game.executeCommand(command);
            assertEquals(true, game.isRobotInitialized());
        }
    }
}
