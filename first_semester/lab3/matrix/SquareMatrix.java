package matrix;

import exception.MatrixException;

public class SquareMatrix extends Matrix {
    
    public SquareMatrix(int size) {
        super(size, size);
        if (size <= 0) {
            throw new MatrixException("Сторона квадратной матрицы должна быть больше 0");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    mtx[i][j] = 1;
                } else {
                    mtx[i][j] = 0;
                }
            }
        }
    }

    @Override
    public void setElement(int row, int column, int value) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            throw new MatrixException("Недопустимые индексы");
        }
        mtx[row][column] = value;
    }

    @Override
    public int getElement(int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            throw new MatrixException("Недопустимые индексы");
        }
        return mtx[row][column];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SquareMatrix)) {
            return false;
        }

        SquareMatrix other = (SquareMatrix) obj;

        if (this.n != other.n) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.mtx[i][j] != other.mtx[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public SquareMatrix sum(Matrix anotherMatrix) {
        if (!(anotherMatrix instanceof SquareMatrix)) {
            throw new MatrixException("Для сложения квадратных матриц нужна квадратная матрица");
        }
        
        SquareMatrix other = (SquareMatrix) anotherMatrix;
        
        if (this.n != other.n) {
            throw new MatrixException("Размеры квадратных матриц должны совпадать");
        }
        
        SquareMatrix result = new SquareMatrix(this.n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.mtx[i][j] = this.mtx[i][j] + other.mtx[i][j];
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("[");
            for (int j = 0; j < n; j++) {
                sb.append(mtx[i][j]);
                if (j < n - 1) {
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