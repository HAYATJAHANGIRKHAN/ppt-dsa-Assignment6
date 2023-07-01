//A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:
//
//        - s[i] == 'I' if perm[i] < perm[i + 1], and
//        - s[i] == 'D' if perm[i] > perm[i + 1].
//
//        Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return **any of them**.
//
//        **Example 1:**
//
//        **Input:** s = "IDID"
//
//        **Output:**
//
//        [0,4,1,3,2]

package ppt_assignment6;

import java.util.*;

    public class PermutationReconstruction {

            public int[] reconstructPermutation(String s) {
                int n = s.length();
                int[] perm = new int[n + 1];
                List<Integer> available = new ArrayList<>();

                // Initialize the available numbers
                for (int i = 0; i <= n; i++) {
                    available.add(i);
                }

                // Reconstruct the permutation
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == 'I') {
                        perm[i] = available.remove(0);
                    } else {
                        perm[i] = available.remove(available.size() - 1);
                    }
                }

                // Add the last remaining number
                perm[n] = available.get(0);

                return perm;
            }

            public static void main(String[] args) {
                PermutationReconstruction solution = new PermutationReconstruction();
                String s = "IDID";
                int[] perm = solution.reconstructPermutation(s);
                for (int num : perm) {
                    System.out.print(num + " ");
                }
            }
        }





