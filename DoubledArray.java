//
//An integer array original is transformed into a **doubled** array changed by appending **twice the value** of every element in original, and then randomly **shuffling** the resulting array.
//
//        Given an array changed, return original *if* changed *is a **doubled** array. If* changed *is not a **doubled** array, return an empty array. The elements in* original *may be returned in **any** order*.
//
//        **Example 1:**
//
//        **Input:** changed = [1,3,4,2,6,8]
//
//        **Output:** [1,3,4]
//
//        **Explanation:** One possible original array could be [1,3,4]:
//
//        - Twice the value of 1 is 1 * 2 = 2.
//        - Twice the value of 3 is 3 * 2 = 6.
//        - Twice the value of 4 is 4 * 2 = 8.
//
//        Other original arrays could be [4,3,1] or [3,1,4].

package ppt_assignment6;

import java.util.*;

import java.util.Random;

public class DoubledArray {
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0]; // If the length is odd, it can't be a doubled array
        }

        // Create a frequency map to count the occurrences of each element in the changed array
        int[] frequency = new int[100001]; // Assuming the range of elements is within 100000
        for (int num : changed) {
            frequency[num]++;
        }

        List<Integer> original = new ArrayList<>();

        // Iterate over the changed array and reconstruct the original array
        for (int num : changed) {
            if (frequency[num] == 0) {
                continue; // Skip if the current element is already used or not present in the changed array
            }

            // Decrease the frequency of the current element in the frequency map
            frequency[num]--;

            // Check if the doubled value of the current element exists in the frequency map
            int doubledValue = num * 2;
            if (doubledValue < frequency.length && frequency[doubledValue] > 0) {
                // Add the current element to the original array
                original.add(num);

                // Decrease the frequency of the doubled value
                frequency[doubledValue]--;
            } else {
                return new int[0]; // If the doubled value doesn't exist, it's not a doubled array
            }
        }

        // Convert the ArrayList to an array and return it
        int[] result = new int[original.size()];
        for (int i = 0; i < original.size(); i++) {
            result[i] = original.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] original = findOriginalArray(changed);
        System.out.println(Arrays.toString(original));
    }
}
