package com.codetest.toyrobot.exceptions;

public class InvalidPositionException extends RobotException {
    private final String position;

    public InvalidPositionException(String command, String position) {
        super(command);
        this.position = position;
    }

    @Override
    public String message() {
        return "Command: " + this.command + " ignored. "
                + "(Reason: Position (" + position + ") is out of board.)";
    }
}
