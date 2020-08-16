package com.codetest.toyrobot.game;

import com.codetest.toyrobot.command.Command;
import com.codetest.toyrobot.logger.RobotLogger;

public class Game {
    private final Board board;
    private Robot robot;

    public Game(int rows, int columns) {
        this.board = new Board(rows, columns);
    }


    /**
     * Execute the command given by argument
     * <p>
     * Note:If the command can not be execute, just ignore it.
     */
    public void executeCommand(Command command) {
        RobotLogger.print(command.toString());
        switch (command.getCommand()) {
            case Command.PLACE:
                this.placeRobot(command.getPosition());
                break;
            case Command.MOVE:
                this.moveRobot();
                break;
            case Command.LEFT:
                this.turnRobotLeft();
                break;
            case Command.RIGHT:
                this.turnRobotRight();
                break;
            case Command.REPORT:
                this.reportRobotPosition();
                break;
            default:
                break;
        }
        if (this.robot != null)
            RobotLogger.print("Current position: (" + this.robot.reportPosition().toString() + ")");
    }

    public void placeRobot(Position position) {
        if (!board.isValidPosition(position)) {
            RobotLogger.printPositionOutOfField();
            return;
        }
        if (this.isRobotInitialized()) {
            this.robot.moveTo(position);
        }
        this.robot = new Robot(position);
    }

    public void moveRobot() {
        if (!this.isRobotInitialized()) {
            RobotLogger.printRobotNotOnBoard();
            return;
        }
        Position newPosition = this.robot.getNextPosition();
        if (board.isValidPosition(newPosition)) {
            this.robot.moveTo(newPosition);
        } else {
            RobotLogger.printPositionOutOfField();
        }
    }

    public void turnRobotLeft() {
        if (!this.isRobotInitialized()) {
            RobotLogger.printRobotNotOnBoard();
            return;
        }
        this.robot.turnLeft();
    }

    public void turnRobotRight() {
        if (!this.isRobotInitialized()) {
            RobotLogger.printRobotNotOnBoard();
            return;
        }
        this.robot.turnRight();
    }

    public void reportRobotPosition() {
        if (!this.isRobotInitialized()) {
            System.out.println("There is no robot on the board.");
            return;
        }
        System.out.println(this.robot.reportPosition().toString());
    }

    public boolean isRobotInitialized() {
        return (this.robot != null);
    }
}
