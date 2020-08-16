package com.codetest.toyrobot.ut;

import com.codetest.toyrobot.command.Command;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {

    @Nested
    public class TestParseAndBuild{
        @Test
        public void testParseAndBuild_whenCommandHasNoArgument_thenCreateCommandWithoutArgument(){
            String commandLine = "MOVE";
            Command command = Command.parseAndBuild(commandLine);
            assertNotEquals(null,command);
            assertEquals(Command.MOVE, command.getCommand());
            assertEquals(null, command.getPosition());
        }

        @Test
        public void testParseAndBuild_whenCommandHasArguments_thenCreateCommandWithArgument(){
            String commandLine = "PLACE 0,0,NORTH";
            Command command = Command.parseAndBuild(commandLine);
            assertNotEquals(null,command);
            assertEquals(Command.PLACE, command.getCommand());
            assertNotEquals(null, command.getPosition());
        }

        @Test
        public void testParseAndBuild_whenCommandArgumentsTooMany_thenReturnCommand(){
            String commandLine = "PLACE 0,0,EAST,0";
            Command command = Command.parseAndBuild(commandLine);
            assertNotEquals(null,command);
            assertEquals(Command.PLACE, command.getCommand());
            assertNotEquals(null, command.getPosition());
        }
        @Test
        public void testParseAndBuild_whenCommandArgumentsNotEnough_thenReturnNull(){
            String commandLine = "PLACE 0,0";
            Command command = Command.parseAndBuild(commandLine);
            assertEquals(null,command);
        }
        @Test
        public void testParseAndBuild_whenCommandLineTooMany_thenReturnCommand(){
            String commandLine = "PLACE 0,0,SOUTH MOVE";
            Command command = Command.parseAndBuild(commandLine);
            assertNotEquals(null,command);
            assertEquals(Command.PLACE, command.getCommand());
            assertNotEquals(null, command.getPosition());
        }
        @Test
        public void testParseAndBuild_whenCommandIsPlaceWithoutArgument_thenReturnNull(){
            String commandLine = "PLACE";
            Command command = Command.parseAndBuild(commandLine);
            assertEquals(null,command);
        }

        @Test
        public void testParseAndBuild_whenCommandLineNull_thenReturnNull(){
            String commandLine = " ";
            Command command = Command.parseAndBuild(commandLine);
            assertEquals(null,command);
        }
        @Test
        public void testParseAndBuild_whenCommandInvalid_thenReturnNull(){
            String commandLine = "BACK";
            Command command = Command.parseAndBuild(commandLine);
            assertEquals(null,command);

            commandLine = "PLACE 0,0,DOWN";
            command = Command.parseAndBuild(commandLine);
            assertEquals(null,command);
        }
    }
    @Test
    public void testGetCommand_whenCalled_thenReturnCommand(){
        String commandLine1 = "LEFT";
        String commandLine2 = "RIGHT";
        String commandLine3 = "REPORT";
        String commandLine4 = "MOVE";
        String commandLine5 = "PLACE 0,0,WEST";
        Command command1 = Command.parseAndBuild(commandLine1);
        Command command2 = Command.parseAndBuild(commandLine2);
        Command command3 = Command.parseAndBuild(commandLine3);
        Command command4 = Command.parseAndBuild(commandLine4);
        Command command5 = Command.parseAndBuild(commandLine5);

        assertEquals(Command.LEFT, command1.getCommand());
        assertEquals(Command.RIGHT, command2.getCommand());
        assertEquals(Command.REPORT, command3.getCommand());
        assertEquals(Command.MOVE, command4.getCommand());
        assertEquals(Command.PLACE, command5.getCommand());
    }
}
