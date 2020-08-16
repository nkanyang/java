package com.codetest.toyrobot.game;

public class Board {
    private final int rows;
    private final int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public boolean isValidPosition(Position position) {
        return (position.getX() < columns && position.getX() >= 0)
                && (position.getY() < rows && position.getY() >= 0);
    }
}
