package com.leetcode.hard.minimum_window_substring;

//  REQUIRES Java 8 for javafx.util.Pair
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //Given two strings s and t of lengths m and n respectively, return the minimum
    //window substring of s such that every character in t (including duplicates) is
    //included in the window. If there is no such substring, return the empty string
    //"".
    //
    // The testcases will be generated such that the answer is unique.
    //
    // A substring is a contiguous sequence of characters within the string.
    //
    //
    // Example 1:
    //
    //
    //Input: s = "ADOBECODEBANC", t = "ABC"
    //Output: "BANC"
    //Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
    //from string t.
    //
    //
    // Example 2:
    //
    //
    //Input: s = "a", t = "a"
    //Output: "a"
    //Explanation: The entire string s is the minimum window.
    //
    //
    // Example 3:
    //
    //
    //Input: s = "a", t = "aa"
    //Output: ""
    //Explanation: Both 'a's from t must be included in the window.
    //Since the largest window of s only has one 'a', return empty string.
    //
    //
    //
    // Constraints:
    //
    //
    // m == s.length
    // n == t.length
    // 1 <= m, n <= 10⁵
    // s and t consist of uppercase and lowercase English letters.
    //
    //
    //
    //Follow up: Could you find an algorithm that runs in O(m + n) time? Related
    //Topics Hash Table String Sliding Window 👍 10893 👎 545


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        java.util.Map<Character, Integer> hMap = new java.util.HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            int count = hMap.getOrDefault(t.charAt(i), 0);
            hMap.put(t.charAt(i), count + 1);
        }

        int required = hMap.size();

        //  Filter all the characters from s into a new list
        //      along with their index.
        //  The filtering criteria is that the character
        //      should be present in t.

        java.util.List<javafx.util.Pair<Integer, Character>> filteredS =
                new java.util.ArrayList<javafx.util.Pair<Integer, Character>>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hMap.containsKey(c)) {
                filteredS.add(new javafx.util.Pair<Integer, Character>(i, c));
            }
        }

        int l = 0, r = 0, formed = 0;
        java.util.Map<Character, Integer> windowCounts =
                new java.util.HashMap<Character, Integer>();
        int[] ans = {-1, 0, 0};

        //  Look for the characters only in the filtered list instead of
        //      entire s.
        //  This helps to reduce our search.
        //  Hence, we follow the sliding window approach on as small list.

        while (r < filteredS.size()) {
            char c = filteredS.get(r).getValue();
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (hMap.containsKey(c) &&
                    windowCounts.get(c).intValue() ==
                            hMap.get(c).intValue()) {
                formed++;
            }

            //  Try and contact the window till the point where it
            //      ceases to be 'desirable'

            while (l <= r && formed == required) {
                c = filteredS.get(l).getValue();

                //  Save the smallest window until now.
                int end = filteredS.get(r).getKey();
                int start = filteredS.get(l).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (hMap.containsKey(c) && windowCounts.get(c).intValue() <
                        hMap.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {

        // Example 1:
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        //  O/P: "BANC"

        // Example 2:
        String s2 = "a";
        String t2 = "a";
        //  O/P: "a"

        // Example 3:
        String s3 = "a";
        String t3 = "aa";
        //  O/P: ""

        System.out.println("Example 1: " + minWindow(s1,t1));
        System.out.println("Example 2: " + minWindow(s2,t2));
        System.out.println("Example 3: " + minWindow(s3,t3));

//        //  Pair requires Java8 and discarded in Java11
//        javafx.util.Pair p1 = new javafx.util.Pair(3,4);
//        System.out.println(p1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

