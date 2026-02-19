class Matrix{
    private int n;
    private int[][] mtx;

    public Matrix(int size){
        n = size;
        mtx = new int[n][n];

        for(int i = 0; i < mtx.length; i++){
            for(int j = 0; j < mtx[i].length; j++){
                if (i == j){
                    mtx[i][j] = 1;
                } else {
                    mtx[i][j] = 0;
                }
            }
        }
    }

    public Matrix sum(Matrix anotherMatrix){
        Matrix sumMatrix = new Matrix(this.n);
        for(int i = 0; i < mtx.length; i++){
            for(int j = 0; j < mtx[0].length; j++){
                sumMatrix.mtx[i][j] = mtx[i][j] + anotherMatrix.mtx[i][j];
            }
        }
        return sumMatrix;
    }

    public Matrix product(Matrix anotherMatrix){
        Matrix productMatrix = new Matrix(this.n);

        for(int i = 0; i < mtx.length; i++){
            for(int j = 0; j < mtx[0].length; j++){
                productMatrix.mtx[i][j] = 0;
                
                for(int k = 0; k < mtx.length; k++){
                    productMatrix.mtx[i][j] += mtx[i][k] * anotherMatrix.mtx[k][j];
                }
            }
        }
        return productMatrix;
    }

    public void setElement(int row, int column, int value){
        mtx[row][column] = value;
    }

    public int getElement(int row, int column){
        return mtx[row][column];
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

public class matrix_lab2{
    public static void main (String args[]){
        Matrix m = new Matrix(2);
        
        m.setElement(0, 0, 1);
        m.setElement(0, 1, 1);
        m.setElement(1, 0, 1);
        m.setElement(1, 1, 0);

        Matrix power = m;
        for (int i = 1; i <= 10; i++) {
            System.out.println("M^" + i + ":");
            System.out.println(power);
            System.out.println();
            
            if (i < 10) {
                power = power.product(m);
            }
        }
    }
}