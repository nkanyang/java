package com.codetest.toyrobot.commands;

import com.codetest.toyrobot.game.Direction;
import com.codetest.toyrobot.game.Position;
import org.apache.log4j.Logger;

public class CommandParser {
    final static Logger logger = Logger.getLogger(CommandParser.class.getName());

    /**
     * parse the string given, if it contains a valid command then
     * create an instance of corresponding Command
     * <p>
     * Note:
     * If there is more arguments than needed at the end of the string separated by blank,
     * it won't affect the parser;
     *
     * @param commandString the string to be parsed
     * @return Command: if the string given contains a valid command; null: if the string given is not valid command
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

    /**
     * parse the string given, if it contains valid arguments for position and direction
     * then create an instance of PlaceCommand
     * <p>
     * Note:
     * If there is more arguments than needed at the end of the string separated by comma,
     * it won't affect the result;
     *
     * @param input the string to be parsed
     * @return PlaceCommand: if the string given contains a valid command; null: if the string given is not valid command
     */
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
