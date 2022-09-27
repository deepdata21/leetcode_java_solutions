package com.leetcode.hard.minimum_window_substring;

import java.util.HashMap;
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

        if (s.length() == 0 || t.length() == 0){
            return "";
        }

        int windowStart = 0;
        int windowEnd;
        int matchedCharacters = 0;
        int substringStart = 0;
        int minWindowSize = s.length() + 1; //  Smallest (maximum) impossible size

        Map<Character, Integer> patternMap = new HashMap<>();

//        t.chars().mapToObj(c -> (char) c)
//                .forEach(c -> patternMap.put(
//                        c, patternMap.getOrDefault(c, 0) + 1));

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            patternMap.put(ch,
                    patternMap.getOrDefault(ch, 0) + 1);
        }

        for (windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            //  Declare and store current character at index windowEnd
            char rightChar = s.charAt(windowEnd);
            if (patternMap.containsKey(rightChar)) {
                patternMap.put(rightChar, patternMap.get(rightChar) - 1);
                if (patternMap.get(rightChar) >= 0) {
                    //  Increase the count of matched characters
                    //      for every encounter of a matching character
                    //  However, ignore if patternMap.get(key) < 0,
                    //      which means the required number matches
                    //      for that key/rightChr have already been accounted for
                    matchedCharacters++;
                }
            }

            while (matchedCharacters == t.length()) {

                //  + 1 b/c 0-indexed
//                int windowLength = windowEnd - windowStart + 1;

                if (minWindowSize > windowEnd - windowStart + 1) {
                    //  Update minimum window size if
                    //      current (properly matching) window length is smaller
                    minWindowSize = windowEnd - windowStart + 1;

                    //  Store the current windowStart as the
                    //      starting index of the required minimum window substring
                    substringStart = windowStart;
                }

                //  Store the character at the start of the window
                //      and, after that increase windowStart by 1
                char leftChar = s.charAt(windowStart++);

                //  Check if the character at the start of the window
                //      is present in the pattern map
                if (patternMap.containsKey(leftChar)) {

                    //  If present, it has already been accounted for
                    //      in matchedCharacters count
                    //  So, if its current count is 0,
                    //      remove it from the count of matchedCharacters
                    //      by decreasing the value of matchedCharacters by 1
                    if (patternMap.get(leftChar) == 0) {
                        matchedCharacters--;
                    }

                    //  If patternMap.get(key/leftchar) is > (i.e. !=) 0 or just 0
                    //     put it back in the pattern map by increasing the value by 1,
                    //     since leftchar is moving out of the window
                    //     in the following/next iteration
                    patternMap.put(leftChar, patternMap.get(leftChar) + 1);
                }
            }
        }

        //  return empty string if minimum substring doesn't exist
        //      (i.e. length of given string > minWindowSize) or
        //      return the minimum window substring
        return minWindowSize > s.length() ?
                "" : s.substring(substringStart, substringStart + minWindowSize);

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

    }
}
//leetcode submit region end(Prohibit modification and deletion)

