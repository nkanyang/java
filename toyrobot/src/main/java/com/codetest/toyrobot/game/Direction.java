package com.codetest.toyrobot.game;

public class Direction {
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    public static final int NUMBER_OF_DIRECTIONS = 4;
    private static final String[] DIRECTIONS = {"NORTH", "EAST", "SOUTH", "WEST"};

    private int directionIndex;

    public Direction(int direction) {
        this.directionIndex = direction;
    }

    public void turnLeft() {
        directionIndex = (directionIndex + 3) % NUMBER_OF_DIRECTIONS;
    }

    public void turnRight() {
        directionIndex = (directionIndex + 1) % NUMBER_OF_DIRECTIONS;
    }

    public int getDirection() {
        return this.directionIndex;
    }

    @Override
    public String toString() {
        return DIRECTIONS[directionIndex];
    }
}
