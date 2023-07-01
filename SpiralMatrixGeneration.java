//Given two sparse matrices mat1 of size m x k and mat2 of size k x n, return the result of mat1 x mat2. You may assume that multiplication is always possible.
//        **Input:** mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]
//
//        **Output:**
//
//        [[7,0,0],[-7,0,3]]




package ppt_assignment6;
import java.util.*;
public class SpiralMatrixGeneration {

        public static int[][] multiply(int[][] mat1, int[][] mat2) {
            int m = mat1.length;
            int k = mat1[0].length;
            int n = mat2[0].length;

            // Create a map to store the non-zero values of mat1
            Map<Integer, Map<Integer, Integer>> map1 = new HashMap<>();
            for (int i = 0; i < m; i++) {
                map1.put(i, new HashMap<>());
                for (int j = 0; j < k; j++) {
                    if (mat1[i][j] != 0) {
                        map1.get(i).put(j, mat1[i][j]);
                    }
                }
            }

            // Create a map to store the non-zero values of mat2
            Map<Integer, Map<Integer, Integer>> map2 = new HashMap<>();
            for (int i = 0; i < k; i++) {
                map2.put(i, new HashMap<>());
                for (int j = 0; j < n; j++) {
                    if (mat2[i][j] != 0) {
                        map2.get(i).put(j, mat2[i][j]);
                    }
                }
            }

            // Perform matrix multiplication
            int[][] result = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = 0;
                    for (int p = 0; p < k; p++) {
                        if (map1.containsKey(i) && map1.get(i).containsKey(p) && map2.containsKey(p) && map2.get(p).containsKey(j)) {
                            sum += map1.get(i).get(p) * map2.get(p).get(j);
                        }
                    }
                    result[i][j] = sum;
                }
            }

            return result;
        }

        public static void main(String[] args) {
            int[][] mat1 = {{1, 0, 0}, {-1, 0, 3}};
            int[][] mat2 = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};

            int[][] result = multiply(mat1, mat2);

            // Print the result
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }


