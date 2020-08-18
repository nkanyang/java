package com.codetest.toyrobot.game;

public enum Direction {
    NORTH("WEST", "EAST"){
        @Override
        public Position getNextPosition(Position current){
            return new Position(current.getX(),current.getY() + 1);
        }
    },
    EAST("NORTH", "SOUTH"){
        @Override
        public Position getNextPosition(Position current){
            return new Position(current.getX() + 1,current.getY());
        }
    },
    SOUTH("EAST", "WEST"){
        @Override
        public Position getNextPosition(Position current){
            return new Position(current.getX(),current.getY() - 1);
        }
    },
    WEST("SOUTH", "NORTH"){
        @Override
        public Position getNextPosition(Position current){
            return new Position(current.getX() -1 ,current.getY());
        }
    };

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

    /**
     * Returns the next position in this direction based on the current position
     */
    public abstract Position getNextPosition(Position current);
}

