package com.codetest.toyrobot.game;

public class Robot {
    private Position position;
    private Direction direction;

    public void setPlace(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void turnLeft() {
        this.direction = this.direction.getLeft();
    }

    public void turnRight() {
        this.direction = this.direction.getRight();
    }

    public void moveTo(Position position) {
        this.position = position;
    }

    public String reportPosition() {
        return this.position + "," + this.direction;
    }

    public Position getNextPosition() {
        return this.direction.getNextPosition(this.position);
    }

    public boolean isOnBoard() {
        return (this.position != null && this.direction != null);
    }
}
