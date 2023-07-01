//Given a binary array nums, return *the maximum length of a contiguous subarray with an equal number of* 0 *and* 1.
//
//        **Example 1:**
//
//        **Input:** nums = [0,1]
//
//        **Output:** 2
//
//        **Explanation:**
//
//        [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

package ppt_assignment6;

import java.util.*;


public class ContiguousSubarray {

    public static int findMaxLength(int[] nums) {
        // Create a HashMap to store the cumulative sum as the key and its corresponding index as the value
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize the map with a sum of 0 at index -1
        int maxLength = 0;
        int count = 0; // Initialize the count of zeros and ones

        for (int i = 0; i < nums.length; i++) {
            // Increment count by 1 for a 1, decrement count by 1 for a 0
            count += nums[i] == 1 ? 1 : -1;

            if (map.containsKey(count)) {
                // If the count exists in the map, update the maxLength
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                // Otherwise, add the count to the map with its corresponding index
                map.put(count, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        int maxLength = findMaxLength(nums);
        System.out.println("Maximum length of a contiguous subarray with equal number of 0s and 1s: " + maxLength);
    }
}
