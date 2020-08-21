package com.codetest.toyrobot.commands;

import com.codetest.toyrobot.exceptions.InvalidPositionException;
import com.codetest.toyrobot.exceptions.RobotException;
import com.codetest.toyrobot.exceptions.RobotNotOnBoardException;
import com.codetest.toyrobot.game.Board;
import com.codetest.toyrobot.game.Position;
import com.codetest.toyrobot.game.Robot;

public class MoveCommand implements Command {
    private final String command = "MOVE";

    @Override
    public void execute(Robot robot, Board board) throws RobotException {
        if (!robot.isOnBoard()) {
            throw new RobotNotOnBoardException(command);
        }
        Position nextPosition = robot.getNextPosition();
        if (!board.isValidPosition(nextPosition)) {
            throw new InvalidPositionException(command, nextPosition.toString());
        }
        robot.moveTo(nextPosition);
    }

    @Override
    public String toString() {
        return this.command;
    }
}
