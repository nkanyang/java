package com.codetest.toyrobot.game;

import java.util.HashMap;
import java.util.Map;

public class Robot {
    private static Map<Direction, Position> offsetMap = new HashMap<Direction, Position>();

    static {
        offsetMap.put(Direction.NORTH, new Position(0, 1));
        offsetMap.put(Direction.EAST, new Position(1, 0));
        offsetMap.put(Direction.SOUTH, new Position(0, -1));
        offsetMap.put(Direction.WEST, new Position(-1, 0));
    }

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
        Position offset = offsetMap.get(this.direction);
        return position.getNewPosition(offset);
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
