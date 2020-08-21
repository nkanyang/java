package com.codetest.toyrobot.exceptions;

public class RobotNotOnBoardException extends RobotException {
    public RobotNotOnBoardException(String command) {
        super(command);
    }

    @Override
    public String message() {
        return "Command: " + this.command + " ignored. "
                + "(Reason: The Robot has't been placed yet.)";
    }
}
