package org.suai.vybornov.lab3.matrix;

import org.suai.vybornov.lab3.exception.MatrixException;

public class SquareMatrix extends Matrix {
    
    public SquareMatrix(int size) throws MatrixException {
        super(size, size);
    }
    
    protected SquareMatrix(int size, boolean lazy) throws MatrixException {
        super(size, size, lazy);
    }
    
    public int getSize() {
        return n;
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}