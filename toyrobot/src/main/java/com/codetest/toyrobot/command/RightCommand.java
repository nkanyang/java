package com.codetest.toyrobot.command;

import com.codetest.toyrobot.exceptions.RobotException;
import com.codetest.toyrobot.exceptions.RobotNotOnBoardException;
import com.codetest.toyrobot.game.Board;
import com.codetest.toyrobot.game.Robot;

public class RightCommand implements Command{
    private String command = "RIGHT";
    @Override
    public void execute(Robot robot, Board board) throws RobotException {
        if(!robot.isOnBoard()){
            throw new RobotNotOnBoardException(command);
        }
        robot.turnRight();
    }
    @Override
    public String toString(){
        return this.command;
    }
}
