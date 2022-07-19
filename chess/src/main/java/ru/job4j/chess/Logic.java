package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException();
        }
        Cell[] steps = figures[index].way(dest);
        if (!free(steps)) {
            throw new OccupiedCellException(
                    String.format("the cell is occupied")
            );
        }
        figures[index] = figures[index].copy(dest);
    }

    private boolean free(Cell[] steps) throws OccupiedCellException, FigureNotFoundException {
        for (Cell cell : steps) {
            if (findBy(cell) > 0) {
                return false;
              // throw new OccupiedCellException(
                        //String.format("the cell is occupied")
               // );
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        //throw new FigureNotFoundException();
        return -1;
    }
}
