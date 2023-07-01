//Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
//**Input:** n = 3
//
//        **Output:** [[1,2,3],[8,9,4],[7,6,5]]


package ppt_assignment6;

import java.util.Arrays;

public class SpiralMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int topRow = 0, bottomRow = n - 1, leftCol = 0, rightCol = n - 1;

        while (num <= n * n) {
            // Fill the top row
            for (int i = leftCol; i <= rightCol; i++) {
                matrix[topRow][i] = num;
                num++;
            }
            topRow++;

            // Fill the right column
            for (int i = topRow; i <= bottomRow; i++) {
                matrix[i][rightCol] = num;
                num++;
            }
            rightCol--;

            // Fill the bottom row
            for (int i = rightCol; i >= leftCol; i--) {
                matrix[bottomRow][i] = num;
                num++;
            }
            bottomRow--;

            // Fill the left column
            for (int i = bottomRow; i >= topRow; i--) {
                matrix[i][leftCol] = num;
                num++;
            }
            leftCol++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] spiralMatrix = generateMatrix(n);

        // Print the matrix
        for (int[] row : spiralMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
