package arrays_hashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {


    /*
      Problem: Given an integer array nums, return true if any value appears at least twice,
    and return false if every element is distinct.

    Approach 1: Brute Force
    - Use nested for loops to compare each element with others.
    - Time: O(n^2), Space: O(1).

     1- Brute force approach could be to use nested for loops where outer for loop starts from 0 to nums.length
    and the inner for loop starts from the outer loop's index + 1 i.e., i+1 so that no element is compared with itself and goes till nums.length.
    2- This way you can compare every element with the other element in the outer for loop .
    3- But running two for loops provide O(n^2) .
     */
    public boolean hasDuplicate(int [] nums){
        for(int i = 0 ; i < nums.length ; i++ ){
            for(int j = i+1; j<nums.length ; j++ ){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false ;
    }

    /* Optimal Approach 2: HashSet (Optimal)
    - Keep track of seen numbers in a set.
            - If a duplicate is found, return true.
            - Time: O(n), Space: O(n).
      Optimal approach uses set which does not allow duplicates so you can check for seen numbers .
            */

    public boolean hasDuplicateOptimal(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicates solver = new ContainsDuplicates();

        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 3, 1};

        System.out.println("Test 1 (Brute): " + solver.hasDuplicate(nums1));   // false
        System.out.println("Test 1 (Optimal): " + solver.hasDuplicateOptimal(nums1)); // false

        System.out.println("Test 2 (Brute): " + solver.hasDuplicate(nums2));   // true
        System.out.println("Test 2 (Optimal): " + solver.hasDuplicateOptimal(nums2)); // true
    }
}
