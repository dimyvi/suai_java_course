package org.suai.vybornov.lab3.matrix;

import org.suai.vybornov.lab3.exception.MatrixException;

public final class AllEqualMatrix extends Matrix {
    
    public AllEqualMatrix(int rows, int columns, int value) throws MatrixException {
        super(rows, columns, true);
        mtx[0][0] = value;
    }
    
    @Override
    public int getElement(int row, int column) throws MatrixException {
        if (row < 0 || row >= n || column < 0 || column >= m) {
            throw new MatrixException("Недопустимые индексы");
        }
        return mtx[0][0];
    }
    
    @Override
    public void setElement(int row, int column, int value) throws MatrixException {
        if (row < 0 || row >= n || column < 0 || column >= m) {
            throw new MatrixException("Недопустимые индексы");
        }
        mtx[0][0] = value;
    }
}