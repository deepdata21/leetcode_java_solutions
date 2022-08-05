package com.leetcode.medium.word_break;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    //Given a string s and a dictionary of strings wordDict, return true if s can
    //be segmented into a space-separated sequence of one or more dictionary words.
    //
    // Note that the same word in the dictionary may be reused multiple times in
    //the segmentation.
    //
    //
    // Example 1:
    //
    //
    //Input: s = "leetcode", wordDict = ["leet","code"]
    //Output: true
    //Explanation: Return true because "leetcode" can be segmented as "leet code".
    //
    //
    // Example 2:
    //
    //
    //Input: s = "applepenapple", wordDict = ["apple","pen"]
    //Output: true
    //Explanation: Return true because "applepenapple" can be segmented as "apple
    //pen apple".
    //Note that you are allowed to reuse a dictionary word.
    //
    //
    // Example 3:
    //
    //
    //Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    //Output: false
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= s.length <= 300
    // 1 <= wordDict.length <= 1000
    // 1 <= wordDict[i].length <= 20
    // s and wordDict[i] consist of only lowercase English letters.
    // All the strings of wordDict are unique.
    //
    //
    // Related Topics Hash Table String Dynamic Programming Trie Memoization 👍 1158
    //👍 11587 👎 499


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordDictSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {

        // Example 1:
        String s1 = "leetcode";
//        List<String> wordDict1 = List.of("leet","code");
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("leet");
        wordDict1.add("code");
        //  O/P: true

        // Example 2:
        String s2 = "applepenapple";
        List<String> wordDict2 = List.of("apple","pen");
//        List<String> wordDict2 = new ArrayList<>();
//        wordDict2.add("apple");
//        wordDict2.add("pen");
        //  O/P: true

        // Example 3:
        String s3 = "catsandog";
//        List<String> wordDict3 = List.of("cats", "dog", "sand", "and", "cat");
        List<String> wordDict3 = new ArrayList<>();
        wordDict3.add("cats");
        wordDict3.add("dog");
        wordDict3.add("sand");
        wordDict3.add("and");
        wordDict3.add("cat");
        //  O/P: false

        System.out.println(wordBreak(s1, wordDict1));
        System.out.println(wordBreak(s2, wordDict2));
        System.out.println(wordBreak(s3, wordDict3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

