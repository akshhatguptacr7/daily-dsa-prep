package arrays_hashing;

import java.util.*;

public class GroupAnagrams {

    /*
      Problem: Given an array of strings strs, group the anagrams together.
      Return the result as a list of lists.

      Definition:
      - An Anagram is a word formed by rearranging the letters of another word.
        Example: "eat" -> "tea" -> "ate".

      Example:
      Input: ["eat","tea","tan","ate","nat","bat"]
      Output: [["eat","tea","ate"],["tan","nat"],["bat"]]

      Approach 1: Sorting (Brute Force)
      1. For each string, sort its characters.
      2. Use the sorted string as a key in a HashMap.
      3. Group words with the same sorted key together.
      - Time: O(n * k log k), where n = number of words, k = max word length
      - Space: O(n * k), storing groups
    */
    public List<List<String>> groupAnagramsBrute(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    /*
      Approach 2: Frequency Count (Optimal)
      1. For each string, count character frequencies using an int[26] array.
      2. Convert frequency array into a unique key (like "1#0#0#...").
      3. Use this key in a HashMap to group anagrams.
      - Time: O(n * k), no sorting needed
      - Space: O(n * k), for storing groups
    */
    public List<List<String>> groupAnagramsOptimal(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solver = new GroupAnagrams();

        String[] input1 = {"eat","tea","tan","ate","nat","bat"};

        System.out.println("Test 1 (Brute): " + solver.groupAnagramsBrute(input1));
        System.out.println("Test 1 (Optimal): " + solver.groupAnagramsOptimal(input1));

        String[] input2 = {""};
        System.out.println("Test 2 (Brute): " + solver.groupAnagramsBrute(input2));
        System.out.println("Test 2 (Optimal): " + solver.groupAnagramsOptimal(input2));

        String[] input3 = {"a"};
        System.out.println("Test 3 (Brute): " + solver.groupAnagramsBrute(input3));
        System.out.println("Test 3 (Optimal): " + solver.groupAnagramsOptimal(input3));
    }
}
