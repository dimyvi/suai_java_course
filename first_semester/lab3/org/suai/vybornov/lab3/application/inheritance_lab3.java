package org.suai.vybornov.lab3.application;

import org.suai.vybornov.lab3.exception.MatrixException;
import org.suai.vybornov.lab3.matrix.AllEqualMatrix;
import org.suai.vybornov.lab3.matrix.Matrix;
import org.suai.vybornov.lab3.matrix.SquareMatrix;

public class inheritance_lab3 {
    public static void main(String args[]) {
        try {
            System.out.println("Обычные матрицы");
            Matrix m1 = new Matrix(2, 2);
            Matrix m2 = new Matrix(2, 2);
            
            m1.setElement(0, 0, 1);
            m1.setElement(0, 1, 2);
            m1.setElement(1, 0, 3);
            m1.setElement(1, 1, 4);
            
            m2.setElement(0, 0, 5);
            m2.setElement(0, 1, 6);
            m2.setElement(1, 0, 7);
            m2.setElement(1, 1, 8);
            
            System.out.println("m1:\n" + m1);
            System.out.println("m2:\n" + m2);
            System.out.println("m1 + m2:\n" + m1.sum(m2));
            System.out.println("m1 * m2:\n" + m1.product(m2));
            System.out.println("m1[0][1] = " + m1.getElement(0, 1));
            System.out.println("m1 equals m2? " + m1.equals(m2));
            
            System.out.println("\nКвадратные матрицы");
            SquareMatrix sm1 = new SquareMatrix(3);
            SquareMatrix sm2 = new SquareMatrix(3);
            
            sm1.setElement(0, 1, 2);
            sm1.setElement(1, 2, 3);
            sm1.setElement(2, 0, 4);
            
            System.out.println("sm1:\n" + sm1);
            System.out.println("sm2:\n" + sm2);
            System.out.println("sm1 + sm2:\n" + sm1.sum(sm2));
            System.out.println("sm1 equals sm2? " + sm1.equals(sm2));
            System.out.println("sm1 * sm2:\n" + sm1.product(sm2));
            
            System.out.println("\nAllEqualMatrix (все элементы одинаковые)");
            AllEqualMatrix aem1 = new AllEqualMatrix(3, 3, 5);
            System.out.println("aem1 (3x3, все = 5):\n" + aem1);
            
            AllEqualMatrix aem2 = new AllEqualMatrix(3, 3, 5);
            AllEqualMatrix aem3 = new AllEqualMatrix(2, 3, 7);
            
            System.out.println("aem1[0][0] = " + aem1.getElement(0, 0));
            System.out.println("aem3[0][0] = " + aem3.getElement(0, 0));
            System.out.println("aem1[1][1] = " + aem1.getElement(1, 1));
            System.out.println("aem3[1][2] = " + aem3.getElement(1, 2));
            
            System.out.println("\nИзменяем aem1[0][0] на 10 (меняются ВСЕ элементы)");
            aem1.setElement(0, 0, 10);
            System.out.println("aem1 после изменения:\n" + aem1);
            
            System.out.println("\naem1 equals aem2 (10 vs 5)? " + aem1.equals(aem2));
            System.out.println("aem1 equals aem3 (3x3 vs 2x3)? " + aem1.equals(aem3));
            
            System.out.println("\naem1[0][0] = " + aem1.getElement(0, 0));
            System.out.println("aem1[1][1] = " + aem1.getElement(1, 1));
            System.out.println("aem1[2][2] = " + aem1.getElement(2, 2));
            
            System.out.println("\nИзменяем aem1[2][2] на 20");
            aem1.setElement(2, 2, 20);
            System.out.println("aem1:\n" + aem1);
            
            System.out.println("\nОперации с AllEqualMatrix");
            Matrix m3 = new Matrix(3, 3);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    m3.setElement(i, j, 1);
                }
            }
            
            System.out.println("m3 (все = 1):\n" + m3);
            System.out.println("aem1 + m3:\n" + aem1.sum(m3));
            System.out.println("aem1 * m3:\n" + aem1.product(m3));
            
            System.out.println("\nУмножение AllEqualMatrix на обычную матрицу");
            Matrix m5 = new Matrix(3, 2);
            m5.setElement(0, 0, 1);
            m5.setElement(0, 1, 2);
            m5.setElement(1, 0, 3);
            m5.setElement(1, 1, 4);
            m5.setElement(2, 0, 5);
            m5.setElement(2, 1, 6);
            
            AllEqualMatrix aem5 = new AllEqualMatrix(2, 3, 2);
            System.out.println("aem5 (2x3, все = 2):\n" + aem5);
            System.out.println("m5 (3x2):\n" + m5);
            System.out.println("aem5 * m5 (2x2):\n" + aem5.product(m5));
            
            System.out.println("\nПроверка исключений");
            try {
                aem1.getElement(5, 5);
            } catch (MatrixException e) {
                System.out.println("Ошибка getElement: " + e.getMessage());
            }
            
            try {
                aem1.setElement(5, 5, 100);
            } catch (MatrixException e) {
                System.out.println("Ошибка setElement: " + e.getMessage());
            }
            
            try {
                AllEqualMatrix aem4 = new AllEqualMatrix(0, 5, 10);
            } catch (MatrixException e) {
                System.out.println("Ошибка создания: " + e.getMessage());
            }
            
            System.out.println("\nСравнение с обычной матрицей ");
            Matrix m4 = new Matrix(3, 3);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    m4.setElement(i, j, 20);
                }
            }
            System.out.println("m4 (все = 20):\n" + m4);
            System.out.println("aem1 equals m4 (все 20 vs все 20)? " + aem1.equals(m4));
            
            System.out.println("\nДополнительные проверки");
            try {
                new Matrix(0, 0);
            } catch (Exception e) {
                System.out.println("Ошибка создания Matrix 0x0: " + e.getMessage());
            }
            
            try {
                m1.getElement(5, 5);
            } catch (Exception e) {
                System.out.println("Ошибка доступа: " + e.getMessage());
            }
            
            try {
                m1.sum(new Matrix(3, 2));
            } catch (Exception e) {
                System.out.println("Ошибка сложения: " + e.getMessage());
            }
            
            System.out.println("\nУмножение AllEqualMatrix разных размеров");
            AllEqualMatrix aem6 = new AllEqualMatrix(2, 4, 3);
            AllEqualMatrix aem7 = new AllEqualMatrix(4, 5, 2);
            System.out.println("aem6 (2x4, все = 3):\n" + aem6);
            System.out.println("aem7 (4x5, все = 2):\n" + aem7);
            System.out.println("aem6 * aem7 (2x5):\n" + aem6.product(aem7));
            
        } catch (Exception e) {
            System.out.println("Общая ошибка: " + e.getMessage());
        }
    }
}