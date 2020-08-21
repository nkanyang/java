package com.codetest.toyrobot.commands;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandParserTest {
    public static CommandParser commandParser = new CommandParser();

    @Nested
    public class BuildFromStringTest {

        @Test
        public void testBuildFromString_whenCommandStringNull_thenReturnNull() {
            assertEquals(null, commandParser.buildFromString(" "));
        }

        @Test
        public void testBuildFromString_whenCommandMove_thenReturnMoveCommandInstance() {
            Command command = commandParser.buildFromString("MOVE");
            assertTrue(command instanceof MoveCommand);
        }

        @Test
        public void testBuildFromString_whenCommandLeft_thenReturnLeftCommandInstance() {
            Command command = commandParser.buildFromString("LEFT");
            assertTrue(command instanceof LeftCommand);
        }

        @Test
        public void testBuildFromString_whenCommandRight_thenReturnRightCommandInstance() {
            Command command = commandParser.buildFromString("RIGHT");
            assertTrue(command instanceof RightCommand);
        }

        @Test
        public void testBuildFromString_whenCommandReport_thenReturnReportCommandInstance() {
            Command command = commandParser.buildFromString("REPORT");
            assertTrue(command instanceof ReportCommand);
        }

        @Test
        public void testBuildFromString_whenCommandPlaceWithNoArgument_thenReturnNull() {
            Command command = commandParser.buildFromString("PLACE");
            assertEquals(null, command);
        }

        @Test
        public void testBuildFromString_whenCommandUnknown_thenReturnNull() {
            Command command = commandParser.buildFromString("UP");
            assertEquals(null, command);
        }
    }

    @Nested
    public class BuildPlaceCommandTest {

        @Test
        public void testBuildPlaceCommand_whenInputNotLegal_thenReturnNull() {
            assertEquals(null, commandParser.buildPlaceCommand(null));
            assertEquals(null, commandParser.buildPlaceCommand("1,1"));
            assertEquals(null, commandParser.buildPlaceCommand("1,1a,NORTH"));
            assertEquals(null, commandParser.buildPlaceCommand("1,1,CENTER"));
        }

        @Test
        public void testBuildPlaceCommand_whenInputLegal_thenReturnPlaceCommandInstance() {
            Command command1 = commandParser.buildPlaceCommand("1,1,WEST");
            Command command2 = commandParser.buildPlaceCommand("1,1,WEST,GO");
            assertTrue(command1 instanceof PlaceCommand);
            assertTrue(command2 instanceof PlaceCommand);
        }
    }
}
