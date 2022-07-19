package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPositionActual() {
        BishopBlack black = new BishopBlack(Cell.B1);
        assertEquals(black.position(), Cell.B1);
    }

    @Test
    public void whenPositionNotActual() {
        BishopBlack black = new BishopBlack(Cell.B1);
        assertNotEquals(black.position(), Cell.A1);
    }

    @Test
    public void whenCopyActual() {
        BishopBlack black = new BishopBlack(Cell.B1);
        assertEquals(black.copy(Cell.A1).position(), Cell.A1);
    }

    @Test
    public void whenCopyNotActual() {
        BishopBlack black = new BishopBlack(Cell.A1);
        assertNotEquals(black.copy(Cell.A2).position(), Cell.A3);
    }

    @Test
    public void whenRightWay() {
        BishopBlack black = new BishopBlack(Cell.C1);
        Cell[] cells = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(black.way(Cell.G5), cells);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNotIsDiagonal() {
        BishopBlack black = new BishopBlack(Cell.B2);
        Cell[] cells = {Cell.C3, Cell.D4, Cell.E5};
        assertArrayEquals(black.way(Cell.E6), cells);
    }
}