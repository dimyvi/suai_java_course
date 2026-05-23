class Vector{
    private int n;
    private int[] el;

    public Vector(int size){
        n = size;
        el = new int[n];
    }

    public Vector(int arr[]){
        n = arr.length;
        el = new int[n];
        for (int i = 0; i < n; i++) {
            el[i] = arr[i];
        }
    }

    public void setElement(int index, int value) {
        if (index >= 0 && index < n) {
            el[index] = value;
        }
    }

    public int getElement(int index) {
        if (index >= 0 && index < n) {
            return el[index];
        }
        return 0;
    }

    public Vector multiply(Matrix matrix) {
        if (this.n != matrix.getSize()) {
            System.out.println("Ошибка");
            return null;
        }
        
        Vector ans = new Vector(matrix.getSize());
        
        for (int j = 0; j < matrix.getSize(); j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += this.el[i] * matrix.getElement(i, j);
            }
            ans.setElement(j, sum);
        }
        
        return ans;
    }

    public int multiply(Vector anotherVector) {
        if (this.n != anotherVector.getSize()) {
            System.out.println("Ошибка");
            return 0;
        }
        
        int scalarProduct = 0;
        for (int i = 0; i < n; i++) {
            scalarProduct += this.el[i] * anotherVector.getElement(i);
        }
        
        return scalarProduct;
    }

    public int getSize() {
        return n;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n; i++) {
            sb.append(el[i]);
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

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
        if (row >= 0 && row < n && column >= 0 && column < n) {
            mtx[row][column] = value;
        }
    }

    public int getElement(int row, int column){
        if (row >= 0 && row < n && column >= 0 && column < n) {
            return mtx[row][column];
        }
        return 0;
    }

    public int getSize(){
        return n;
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
        m.setElement(0, 1, 0);
        m.setElement(1, 0, 0);
        m.setElement(1, 1, 1);
        Matrix power = m;
        for (int i = 1; i <= 10; i++) {
            System.out.println("M^" + i + ":");
            System.out.println(power);
            System.out.println();
            
            if (i < 10) {
                power = power.product(m);
            }
        }

        Vector v1 = new Vector(new int[]{1, 3});
        Vector v2 = new Vector(new int[]{18, 7});
        
        System.out.println("Вектор v1: " + v1);
        System.out.println("Вектор v2: " + v2);

        int scalarProduct = v1.multiply(v2);
        System.out.println("v1 * v2 = " + scalarProduct);

        Vector v1_mult_matrix = v1.multiply(m);
        System.out.println("v1 * M = " + v1_mult_matrix);
        
        Vector v3 = new Vector(3);
        v3.setElement(0, 1);
        v3.setElement(1, 2);
        v3.setElement(2, 3);
        System.out.println("\nВектор v3 размерности 3: " + v3);
        System.out.println("Тут ошибка кбудет v3 на v1:");
        int badProduct = v3.multiply(v1); 
    }
}