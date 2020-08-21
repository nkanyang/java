package com.codetest.toyrobot.commands;

import com.codetest.toyrobot.exceptions.RobotException;
import com.codetest.toyrobot.exceptions.RobotNotOnBoardException;
import com.codetest.toyrobot.game.Board;
import com.codetest.toyrobot.game.Robot;

public class ReportCommand implements Command {
    private final String command = "REPORT";

    @Override
    public void execute(Robot robot, Board board) throws RobotException {
        if (!robot.isOnBoard()) {
            throw new RobotNotOnBoardException(command);
        }
        System.out.println(robot.reportPosition());
    }

    @Override
    public String toString() {
        return this.command;
    }
}
