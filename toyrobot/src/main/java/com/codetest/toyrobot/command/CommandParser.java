package com.codetest.toyrobot.command;

import com.codetest.toyrobot.game.Direction;
import com.codetest.toyrobot.game.Game;
import com.codetest.toyrobot.game.Position;
import org.apache.log4j.Logger;

public class CommandParser {
    final static Logger logger = Logger.getLogger(CommandParser.class.getName());

    /**
     * Parse the String given by argument and return an object of Command
     * <p>
     * Note:If there is more arguments than needed in the string, it won't affect the parser;
     *
     * @param commandString the string contains a command
     * @return Command: if the string given is a valid command
     * null:  if the string given is not valid command
     */
    public Command buildFromString(String commandString) {
        String[] tempArr = commandString.split(" ");
        if (tempArr.length == 0) {
            return null;
        }

        String command = tempArr[0];
        switch (command) {
            case "MOVE":
                return new MoveCommand();
            case "LEFT":
                return new LeftCommand();
            case "RIGHT":
                return new RightCommand();
            case "REPORT":
                return new ReportCommand();
            case "PLACE": {
                if (tempArr.length == 1) {
                    return null;
                }
                return this.buildPlaceCommand(tempArr[1]);
            }
            default:
                return null;
        }
    }

    public PlaceCommand buildPlaceCommand(String input) {
        if (input == null) {
            return null;
        }
        String[] arguments = input.split(",");
        if (arguments.length < 3) {
            return null;
        }
        try {
            int x = Integer.parseInt(arguments[0]);
            int y = Integer.parseInt(arguments[1]);
            Direction direction = Direction.valueOf(arguments[2]);
            return new PlaceCommand(new Position(x, y), direction);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return null;
    }
}
