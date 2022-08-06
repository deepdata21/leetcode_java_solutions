package com.leetcode.hard.alien_dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    //There is a new alien language that uses the English alphabet. However, the
    //order among the letters is unknown to you.
    //
    // You are given a list of strings words from the alien language's dictionary,
    //where the strings in words are sorted lexicographically by the rules of this new
    //language.
    //
    // Return a string of the unique letters in the new alien language sorted in
    //lexicographically increasing order by the new language's rules. If there is no
    //solution, return "". If there are multiple solutions, return any of them.
    //
    // A string s is lexicographically smaller than a string t if at the first
    //letter where they differ, the letter in s comes before the letter in t in the alien
    //language. If the first min(s.length, t.length) letters are the same, then s is
    //smaller if and only if s.length < t.length.
    //
    //
    // Example 1:
    //
    //
    //Input: words = ["wrt","wrf","er","ett","rftt"]
    //Output: "wertf"
    //
    //
    // Example 2:
    //
    //
    //Input: words = ["z","x"]
    //Output: "zx"
    //
    //
    // Example 3:
    //
    //
    //Input: words = ["z","x","z"]
    //Output: ""
    //Explanation: The order is invalid, so return "".
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= words.length <= 100
    // 1 <= words[i].length <= 100
    // words[i] consists of only lowercase English letters.
    //
    //
    // Related Topics Array String Depth-First Search Breadth-First Search Graph
    //Topological Sort 👍 3766 👎 786


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
        private static Map<Character, List<Character>> reverseAdjListMap =
                new HashMap<>();

        private static Map<Character, Boolean> seenMap = new HashMap<>();

        private static StringBuilder result = new StringBuilder();

        static String alienOrder(String[] words) {

            //   Step 0: Put all unique letters into reverseAdjListMap as keys
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    reverseAdjListMap.putIfAbsent(c, new ArrayList<>());
                }
            }

            //  Step 1: Find all edges and add reverse edges to reverseAdjListMap
            for (int i = 0; i < words.length - 1; i++) {

                String word1 = words[i];
                String word2 = words[i + 1];

                // Check that word2 is not a prefix of word1.
                if (word1.length() > word2.length() && word1.startsWith(word2)) {
                    return "";
                }

                //  Find the first non-match and insert the corresponding relation
                for (int j = 0; j < java.lang.Math.min(word1.length(), word2.length());
                     j++){
                    if (word1.charAt(j) != word2.charAt(j)) {
                        reverseAdjListMap.get(word2.charAt(j)).add(word1.charAt(j));
                        break;
                    }
                }
            }

            // Step 2: DFS to build up the result
            for (Character c : reverseAdjListMap.keySet()) {
                boolean flag = dfs(c);
                if (!flag) return "";
            }

            return result.toString();
        }

        //   Return true if and only if no cycles detected
        private static boolean dfs (Character c) {
            if (seenMap.containsKey(c)) {
                //  If this node was grey (false), a cycle was detected
                return seenMap.get(c);
            }
            seenMap.put(c, false);

            for (Character next : reverseAdjListMap.get(c)) {
                boolean flag = dfs(next);
                if (!flag) return false;
            }
            seenMap.put(c, true);

            result.append(c);
            return true;
        }

    public static void main(String[] args) {

        // Example 1:
        String[] words1 = {"wrt","wrf","er","ett","rftt"};
        //  O/P: "wertf"

        // Example 2:
        String[] words2 = {"z","x"};
        //  O/P: "zx"

        // Example 3:
        String[] words3 = {"z","x","z"};
        //  O/P: ""

        System.out.println(alienOrder(words1));
//        System.out.println(alienOrder(words2));
//        System.out.println(alienOrder(words3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

