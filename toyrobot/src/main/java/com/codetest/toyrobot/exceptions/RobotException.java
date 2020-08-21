package com.codetest.toyrobot.exceptions;

public abstract class RobotException extends Exception {
    protected final String command;

    public RobotException(String command) {
        this.command = command;
    }

    public abstract String message();
}
