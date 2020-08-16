package com.codetest.toyrobot.game;

public class Position {
    private final int x;
    private final int y;
    private final Direction direction;

    public Position(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = new Direction(direction);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * Returns the next position based on current position(x,y) and current direction
     */
    public Position getNextPosition() {
        int nextX = this.x;
        int nextY = this.y;

        switch (this.direction.getDirection()) {
            case Direction.NORTH:
                nextY++;
                break;
            case Direction.EAST:
                nextX++;
                break;
            case Direction.SOUTH:
                nextY--;
                break;
            case Direction.WEST:
                nextX--;
                break;
            default:
        }
        return new Position(nextX, nextY, this.direction.getDirection());
    }

    @Override
    public String toString() {
        return this.x + "," + this.y + "," + this.getDirection().toString();
    }
}

