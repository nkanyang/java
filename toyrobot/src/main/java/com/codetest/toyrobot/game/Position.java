package com.codetest.toyrobot.game;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getNewPosition(Position offset) {
        return new Position(this.x + offset.getX(), this.y + offset.getY());
    }

    @Override
    public String toString() {
        return this.x + "," + this.y;
    }
}
