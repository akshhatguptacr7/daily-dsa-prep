package arrays_hashing;

import java.util.Arrays;

public class ValidAnagram {

    /*
      Problem: Given two strings s and t, return true if t is an anagram of s,
      and false otherwise.

      Definition:
      - An Anagram is a word formed by rearranging the letters of another word.
        Example: "listen" -> "silent", "rat" -> "tar".

      Approach 1: Sorting (Brute Force)
      1. If the lengths of s and t are not equal, they cannot be anagrams.
      2. Convert both strings into character arrays.
      3. Sort both arrays.
      4. Compare the sorted arrays:
         - If equal -> they are anagrams
         - Otherwise -> not anagrams
      - Time: O(n log n) due to sorting
      - Space: O(1) if we ignore the sorting space
    */

    public boolean isAnagramBrute(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }

    /*
      Approach 2: Frequency Count (Optimal)
      1. If lengths are not equal -> return false.
      2. Use an integer array of size 26 to count character frequencies.
         - Increment count for each character in s.
         - Decrement count for each character in t.
      3. After processing both strings,
         - If all counts are zero -> they are anagrams.
         - Otherwise -> not anagrams.
      - Time: O(n) since we only traverse both strings once
      - Space: O(1), because the count array size is fixed (26 letters)
    */

    public boolean isAnagramOptimal(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solver = new ValidAnagram();

        String s1 = "listen", t1 = "silent";
        String s2 = "rat", t2 = "car";
        String s3 = "anagram", t3 = "nagaram";

        System.out.println("Test 1 (Brute): " + solver.isAnagramBrute(s1, t1));
        System.out.println("Test 1 (Optimal): " + solver.isAnagramOptimal(s1, t1));

        System.out.println("Test 2 (Brute): " + solver.isAnagramBrute(s2, t2));
        System.out.println("Test 2 (Optimal): " + solver.isAnagramOptimal(s2, t2));

        System.out.println("Test 3 (Brute): " + solver.isAnagramBrute(s3, t3));
        System.out.println("Test 3 (Optimal): " + solver.isAnagramOptimal(s3, t3));
    }
}
