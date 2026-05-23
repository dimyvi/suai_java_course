package org.suai.vybornov.lab3.matrix;

import org.suai.vybornov.lab3.exception.MatrixException;

public class Matrix {
    protected final int n;
    protected final int m;
    protected final int[][] mtx;
    
    public Matrix(int rows, int columns) throws MatrixException {
        if (rows <= 0 || columns <= 0) {
            throw new MatrixException("Значения размеров матрицы меньше 0");
        }
        this.n = rows;
        this.m = columns;
        this.mtx = new int[rows][columns];
    }
    
    protected Matrix(int rows, int columns, boolean lazy) throws MatrixException {
        if (rows <= 0 || columns <= 0) {
            throw new MatrixException("Значения размеров матрицы меньше 0");
        }
        this.n = rows;
        this.m = columns;
        this.mtx = new int[1][1];
    }
    
    public int getElement(int row, int column) throws MatrixException {
        if (row < 0 || row >= n || column < 0 || column >= m) {
            throw new MatrixException("Недопустимые индексы");
        }
        return mtx[row][column];
    }
    
    public void setElement(int row, int column, int value) throws MatrixException {
        if (row < 0 || row >= n || column < 0 || column >= m) {
            throw new MatrixException("Недопустимые индексы");
        }
        mtx[row][column] = value;
    }
    
    public Matrix sum(Matrix other) throws MatrixException {
        if (this.n != other.n || this.m != other.m) {
            throw new MatrixException("Разные размеры матриц");
        }
        Matrix result = new Matrix(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.setElement(i, j, this.getElement(i, j) + other.getElement(i, j));
            }
        }
        return result;
    }
    
    public Matrix product(Matrix other) throws MatrixException {
        if (this.m != other.n) {
            throw new MatrixException("Нельзя перемножить матрицы");
        }
        Matrix result = new Matrix(this.n, other.m);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < other.m; j++) {
                int sum = 0;
                for (int k = 0; k < this.m; k++) {
                    sum += this.getElement(i, k) * other.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Matrix)) return false;
        Matrix matrix = (Matrix) obj;
        if (n != matrix.n || m != matrix.m) return false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                try {
                    if (this.getElement(i, j) != matrix.getElement(i, j)) return false;
                } catch (MatrixException e) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("[");
            for (int j = 0; j < m; j++) {
                try {
                    sb.append(getElement(i, j));
                } catch (MatrixException e) {
                    sb.append("?");
                }
                if (j < m - 1) sb.append(" ");
            }
            sb.append("]");
            if (i < n - 1) sb.append("\n");
        }
        return sb.toString();
    }
}