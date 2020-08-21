package com.codetest.toyrobot.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    @Test
    public void testIsValidPosition_whenOutOfBoard_thenReturnFalse() {
        int rows = 5;
        int columns = 5;
        Board board = new Board(rows, columns);
        assertEquals(false,
                board.isValidPosition(new Position(-1, 0)));
        assertEquals(false,
                board.isValidPosition(new Position(0, -1)));
        assertEquals(false,
                board.isValidPosition(new Position(0, columns)));
        assertEquals(false,
                board.isValidPosition(new Position(rows, 0)));
    }

    @Test
    public void testIsValidPosition_whenOnBoard_thenReturnTrue() {
        int rows = 5;
        int columns = 5;
        Board board = new Board(rows, columns);
        assertEquals(true,
                board.isValidPosition(new Position(0, 0)));
        assertEquals(true,
                board.isValidPosition(new Position(0, columns - 1)));
        assertEquals(true,
                board.isValidPosition(new Position(rows - 1, 0)));
        assertEquals(true,
                board.isValidPosition(new Position(rows - 1, columns - 1)));
    }
}
