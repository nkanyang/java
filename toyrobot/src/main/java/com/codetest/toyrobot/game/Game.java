package com.codetest.toyrobot.game;

import com.codetest.toyrobot.command.Command;
import com.codetest.toyrobot.exceptions.RobotException;

import java.util.logging.Logger;

public class Game {
    private final Logger logger = Logger.getLogger(Game.class.getName());
    private final Board board;
    private Robot robot;

    public Game(int rows, int columns) {
        this.board = new Board(rows, columns);
        this.robot = new Robot();
    }

    /**
     * Execute the command given by argument
     *
     * Note:If the command can not be execute, just ignore it.
     */
    public void executeCommand(Command command){
        try{
            command.execute(this.robot, this.board);
            logger.info(command.toString());
        }catch (RobotException e){
            logger.warning(e.message());
        }
    }
}
