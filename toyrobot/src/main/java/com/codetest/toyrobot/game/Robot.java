package com.codetest.toyrobot.game;

public class Robot {
    private Position position;

    public Robot(Position position) {
        this.position = position;
    }

    public void turnLeft() {
        this.position.getDirection().turnLeft();
    }

    public void turnRight() {
        this.position.getDirection().turnRight();
    }

    public void moveTo(Position position) {
        this.position = position;
    }

    public Position reportPosition() {
        return this.position;
    }

    public Position getNextPosition() {
        return this.position.getNextPosition();
    }
}
