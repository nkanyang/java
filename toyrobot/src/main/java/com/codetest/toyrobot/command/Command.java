package com.codetest.toyrobot.command;

import com.codetest.toyrobot.game.Direction;
import com.codetest.toyrobot.game.Position;

public class Command {
    public static final int PLACE = 0;
    public static final int MOVE = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    public static final int REPORT = 4;
    private static final String[] commands = {"PLACE", "MOVE", "LEFT", "RIGHT", "REPORT"};

    private final int commandIndex;
    private Position position = null;

    public Command(int command, Position position) {
        this.commandIndex = command;
        this.position = position;
    }

    public Command(int command) {
        this.commandIndex = command;
    }

    /**
     * Parse the String given by argument and return an object of Command
     * <p>
     * Note:If there is more arguments than needed in the string, it won't affect the parser;
     *
     * @param commandString the string contains a command
     * @return Command: if the string given is a valid command
     * null:  if the string given is not valid command
     */
    public static Command parseAndBuild(String commandString) {
        String[] tempArr = commandString.split(" ");
        if (tempArr.length == 0) {
            return null;
        }

        String command = tempArr[0];
        switch (command) {
            case "MOVE":
                return new Command(Command.MOVE);
            case "LEFT":
                return new Command(Command.LEFT);
            case "RIGHT":
                return new Command(Command.RIGHT);
            case "REPORT":
                return new Command(Command.REPORT);
            case "PLACE": {
                if (tempArr.length == 1) {
                    return null;
                }

                String[] arguments = tempArr[1].split(",");
                if (arguments.length < 3) {
                    return null;
                }
                int x = Integer.parseInt(arguments[0]);
                int y = Integer.parseInt(arguments[1]);
                int direction;
                String directionString = arguments[2];
                switch (directionString) {
                    case "NORTH":
                        direction = Direction.NORTH;
                        break;
                    case "EAST":
                        direction = Direction.EAST;
                        break;
                    case "SOUTH":
                        direction = Direction.SOUTH;
                        break;
                    case "WEST":
                        direction = Direction.WEST;
                        break;
                    default:
                        return null;
                }
                return new Command(Command.PLACE, new Position(x, y, direction));
            }
            default:
                return null;
        }
    }

    public int getCommand() {
        return commandIndex;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        String commandString = commands[this.commandIndex];
        if (position != null) {
            commandString = commandString + " " + position.toString();
        }
        return commandString;
    }
}
