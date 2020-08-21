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

    /**
     * Returns the next position based on current position(x,y) and current direction
     */
    public Position getNextPosition() {
        int nextX = this.position.getX();
        int nextY = this.position.getY();

        switch (this.direction) {
            case NORTH:
                nextY++;
                break;
            case EAST:
                nextX++;
                break;
            case SOUTH:
                nextY--;
                break;
            case WEST:
                nextX--;
                break;
            default:
                throw new IllegalStateException("Direction unknown" + this.direction);
        }
        return new Position(nextX, nextY);
    }

    public boolean isOnBoard() {
        return (this.position != null && this.direction != null);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
