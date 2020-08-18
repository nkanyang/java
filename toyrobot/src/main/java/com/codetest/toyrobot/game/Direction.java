package com.codetest.toyrobot.game;

public enum Direction {
    NORTH("WEST", "EAST"),
    EAST("NORTH", "SOUTH"),
    SOUTH("EAST", "WEST"),
    WEST("SOUTH", "NORTH");

    private String left;
    private String right;

    Direction(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public Direction getLeft(){
        return valueOf(this.left);
    }

    public Direction getRight(){
        return valueOf(this.right);
    }
}

