package arrays_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
      Problem: Given an array of integers nums and an integer target,
      return indices of the two numbers such that they add up to target.
      You may assume that each input would have exactly one solution,
      and you may not use the same element twice.

      Example:
      nums = [2,7,11,15], target = 9
      Output: [0,1] (because nums[0] + nums[1] = 2 + 7 = 9)

      Approach 1: Brute Force
      1. Use nested for loops to check every pair.
      2. If nums[i] + nums[j] == target, return [i, j].
      - Time: O(n^2), since we check all pairs
      - Space: O(1), no extra space used
    */
    public int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /*
      Approach 2: HashMap (Optimal)
      1. Create a HashMap to store numbers and their indices.
      2. For each number:
         - Compute complement = target - nums[i].
         - If complement exists in map -> solution found.
         - Otherwise, add nums[i] into map.
      - Time: O(n), since we traverse array once
      - Space: O(n), for the HashMap
    */
    public int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] nums2 = {3, 2, 4};
        int target2 = 6;

        int[] nums3 = {3, 3};
        int target3 = 6;

        // Test cases
        System.out.println("Test 1 (Brute): " + Arrays.toString(solver.twoSumBrute(nums1, target1)));
        System.out.println("Test 1 (Optimal): " + Arrays.toString(solver.twoSumOptimal(nums1, target1)));

        System.out.println("Test 2 (Brute): " + Arrays.toString(solver.twoSumBrute(nums2, target2)));
        System.out.println("Test 2 (Optimal): " + Arrays.toString(solver.twoSumOptimal(nums2, target2)));

        System.out.println("Test 3 (Brute): " + Arrays.toString(solver.twoSumBrute(nums3, target3)));
        System.out.println("Test 3 (Optimal): " + Arrays.toString(solver.twoSumOptimal(nums3, target3)));
    }
}
