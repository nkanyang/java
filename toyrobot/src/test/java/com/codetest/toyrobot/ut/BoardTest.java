package com.codetest.toyrobot.ut;

import com.codetest.toyrobot.game.Board;
import com.codetest.toyrobot.game.Direction;
import com.codetest.toyrobot.game.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void testIsValidPosition_whenOutOfBoard_thenReturnFalse(){
        int rows = 5;
        int columns = 5;
        Board board = new Board(rows,columns);
        assertEquals(false,
                board.isValidPosition(new Position(-1,0, Direction.SOUTH)));
        assertEquals(false,
                board.isValidPosition(new Position(0,-1, Direction.SOUTH)));
        assertEquals(false,
                board.isValidPosition(new Position(0,columns, Direction.SOUTH)));
        assertEquals(false,
                board.isValidPosition(new Position(rows,0, Direction.SOUTH)));
    }

    @Test
    public void testIsValidPosition_whenOnBoard_thenReturnTrue(){
        int rows = 5;
        int columns = 5;
        Board board = new Board(rows,columns);
        assertEquals(true,
                board.isValidPosition(new Position(0,0, Direction.SOUTH)));
        assertEquals(true,
                board.isValidPosition(new Position(0,columns - 1, Direction.SOUTH)));
        assertEquals(true,
                board.isValidPosition(new Position(rows -1 ,0, Direction.SOUTH)));
        assertEquals(true,
                board.isValidPosition(new Position(rows -1,columns - 1, Direction.SOUTH)));
    }
//    @Test
//    public void testPlace_whenPositionOnBoard_ShouldBeUnvalid(){
//
//    }
}
