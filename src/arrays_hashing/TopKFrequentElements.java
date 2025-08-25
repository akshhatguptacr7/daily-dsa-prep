package arrays_hashing;

import java.util.*;

/*
  Problem: Top K Frequent Elements
  --------------------------------
  Given an integer array nums and an integer k, return the k most frequent elements.
  You may return the answer in any order.

  Example:
  Input: nums = [1,1,1,2,2,3], k = 2
  Output: [1,2]

  ---------------------------------------------------------
  Approach: Using HashMap + Min-Heap (PriorityQueue)
  ---------------------------------------------------------
  1. Count frequencies of each element using a HashMap:
     - Key = element
     - Value = frequency
  2. Use a Min-Heap (PriorityQueue) of size k to keep track of the top k elements:
     - Store pairs (frequency, element) inside the heap.
     - The heap is sorted by frequency (smallest at top).
  3. For each element in the map:
     - Insert into the heap.
     - If heap size exceeds k, remove the smallest frequency element.
  4. At the end, extract the elements from the heap → these are the top k frequent.

  Complexity:
  - Building frequency map → O(n)
  - Heap operations → O(n log k)
  - Overall: O(n log k), which is efficient for large inputs.
  - Space: O(n) for HashMap and Heap.
*/

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-Heap with comparator on frequency
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Step 3: Add elements to heap and maintain size k
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll(); // remove smallest frequency
            }
        }

        // Step 4: Extract result
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements solver = new TopKFrequentElements();

        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Test 1: " + Arrays.toString(solver.topKFrequent(nums1, k1))); // [1, 2]

        int[] nums2 = {4, 4, 4, 5, 5, 6};
        int k2 = 1;
        System.out.println("Test 2: " + Arrays.toString(solver.topKFrequent(nums2, k2))); // [4]
    }
}
