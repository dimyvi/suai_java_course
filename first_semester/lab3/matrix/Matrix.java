package matrix;

import exception.MatrixException;

public class Matrix {
    protected int[][] mtx;
    protected int n, m;

    public Matrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new MatrixException("Значения размеров матрицы меньше 0");
        }
        this.n = rows;
        this.m = columns;
        this.mtx = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mtx[i][j] = 0;
            }
        }
    }

    public Matrix sum(Matrix anotherMatrix) {
        if (this.n != anotherMatrix.n || this.m != anotherMatrix.m) {
            throw new MatrixException("Разные размеры матриц");
        }

        Matrix sumMatrix = new Matrix(this.n, this.m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sumMatrix.mtx[i][j] = mtx[i][j] + anotherMatrix.mtx[i][j];
            }
        }
        return sumMatrix;
    }

    final public Matrix product(Matrix anotherMatrix) {
        if (this.m != anotherMatrix.n) {
            throw new MatrixException("Количество строк не равно количеству столбцов");
        }

        Matrix productMatrix = new Matrix(this.n, anotherMatrix.m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < anotherMatrix.m; j++) {
                productMatrix.mtx[i][j] = 0;
                
                for (int k = 0; k < m; k++) {
                    productMatrix.mtx[i][j] += mtx[i][k] * anotherMatrix.mtx[k][j];
                }
            }
        }
        return productMatrix;
    }

    public void setElement(int row, int column, int value) {
        if (row < 0 || row >= n || column < 0 || column >= m) {
            throw new MatrixException("Недопустимые индексы");
        }
        mtx[row][column] = value;
    }

    public int getElement(int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= m) {
            throw new MatrixException("Недопустимые индексы");
        }
        return mtx[row][column];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Matrix)) {
            return false;
        }

        Matrix other = (Matrix) obj;

        if (this.n != other.n || this.m != other.m) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (this.mtx[i][j] != other.mtx[i][j]) {
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
                sb.append(mtx[i][j]);
                if (j < m - 1) {
                    sb.append(" ");
                }
            }
            sb.append("]");
            if (i < n - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}