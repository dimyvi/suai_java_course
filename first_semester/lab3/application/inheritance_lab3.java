package application;

import matrix.Matrix;
import matrix.SquareMatrix;
import exception.MatrixException;

public class inheritance_lab3{
    public static void main (String args[]){
        try {
        Matrix m1 = new Matrix(2,2);
        Matrix m2 = new Matrix(2,2);
        
        m1.setElement(0,0,1); m1.setElement(0,1,2);
        m1.setElement(1,0,3); m1.setElement(1,1,4);
        
        m2.setElement(0,0,5); m2.setElement(0,1,6);
        m2.setElement(1,0,7); m2.setElement(1,1,8);
        
        System.out.println(m1+"\n");
        System.out.println(m1.sum(m2)+"\n");
        System.out.println(m1.product(m2)+"\n");
        System.out.println(m1.getElement(0,1)+"\n");
        System.out.println(m1.equals(m2)+"\n");
        
        SquareMatrix sm1 = new SquareMatrix(3);
        SquareMatrix sm2 = new SquareMatrix(3);
        
        sm1.setElement(0,1,2);
        sm1.setElement(1,2,3);
        sm1.setElement(2,0,4);
        
        System.out.println(sm1+"\n");
        System.out.println(sm1.sum(sm2)+"\n");
        System.out.println(sm1.equals(sm2)+"\n");
        System.out.println(sm1.product(sm2)+"\n");
        
        try{
            new Matrix(0,0); 
            }catch(Exception e){ 
                System.out.println(e.getMessage());
            }
        
        try{
            m1.getElement(5,5);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            m1.sum(new Matrix(3,2));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    } catch(Exception e) {
        System.out.println(e.getMessage());
    }
    }
}