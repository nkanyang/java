package com.codetest.toyrobot.commands;

import com.codetest.toyrobot.exceptions.InvalidPositionException;
import com.codetest.toyrobot.exceptions.RobotException;
import com.codetest.toyrobot.game.Board;
import com.codetest.toyrobot.game.Direction;
import com.codetest.toyrobot.game.Position;
import com.codetest.toyrobot.game.Robot;

public class PlaceCommand implements Command {
    private final String command = "PLACE";
    private final Position position;
    private final Direction direction;

    public PlaceCommand(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    @Override
    public void execute(Robot robot, Board board) throws RobotException {
        if (!board.isValidPosition(position)) {
            throw new InvalidPositionException(command, position.toString());
        }
        robot.setPlace(this.position, this.direction);
    }

    @Override
    public String toString() {
        return this.command + " " + this.position + "," + this.direction;
    }
}
