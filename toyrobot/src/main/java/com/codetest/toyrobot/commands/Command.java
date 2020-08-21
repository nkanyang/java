package com.codetest.toyrobot.commands;

import com.codetest.toyrobot.exceptions.RobotException;
import com.codetest.toyrobot.game.Board;
import com.codetest.toyrobot.game.Robot;

public interface Command {
    void execute(Robot robot, Board board) throws RobotException;
}
