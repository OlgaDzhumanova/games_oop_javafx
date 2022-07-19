package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.*;

public class LogicTest {

    @Test(expected = FigureNotFoundException.class)
    public void moveWhenNotFoundCell() throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C2, Cell.H6);
    }

    @Test(expected = OccupiedCellException.class)
    public void moveWhenOccupiedCell() throws FigureNotFoundException, OccupiedCellException {
        BishopBlack black = new BishopBlack(Cell.C1);
        BishopBlack bishopBlack = new BishopBlack(Cell.F4);
        Logic logic = new Logic();
        logic.add(black);
        logic.add(bishopBlack);
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void moveWhenImpossibleMove() throws FigureNotFoundException, OccupiedCellException {
        BishopBlack black = new BishopBlack(Cell.C1);
        Logic logic = new Logic();
        logic.add(black);
        logic.move(Cell.C1, Cell.F5);
    }
}
