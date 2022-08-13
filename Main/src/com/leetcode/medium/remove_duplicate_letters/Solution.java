package com.leetcode.medium.remove_duplicate_letters;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Solution {
    //Given a string s, remove duplicate letters so that every letter appears once
    //and only once. You must make sure your result is the smallest in lexicographical
    //order among all possible results.
    //
    //
    // Example 1:
    //
    //
    //Input: s = "bcabc"
    //Output: "abc"
    //
    //
    // Example 2:
    //
    //
    //Input: s = "cbacdcbc"
    //Output: "acdb"
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= s.length <= 10⁴
    // s consists of lowercase English letters.
    //
    //
    //
    // Note: This question is the same as 1081: https://leetcode.com/problems/
    //smallest-subsequence-of-distinct-characters/
    //
    // Related Topics String Stack Greedy Monotonic Stack 👍 5744 👎 375

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static String removeDuplicateLetters(String s) {

        //  The stack
//        java.util.Deque<Character> charStack = new java.util.ArrayDeque<>();
        Deque<Character> charStack = new ArrayDeque<>();

        //  O(1) search time
        Set<Character> seenElement = new HashSet<>();

        //  Check duplicates
        Map<Character, Integer> hMap= new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            hMap.put(s.charAt(i), i);
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seenElement.contains(c)) {
                while (!charStack.isEmpty() &&
                        c < charStack.peek() &&
                        hMap.get(charStack.peek()) > i) {
                    seenElement.remove(charStack.pop());
                }
                seenElement.add(c);
                charStack.push(c);
            }
        }

        StringBuilder sBuilder = new StringBuilder(charStack.size());

        Iterator<Character> charStackReversed = charStack.descendingIterator();

        while (charStackReversed.hasNext()) {
             sBuilder.append(charStackReversed.next());
        }
        //  Doesn't work with stack built with Deque
//        for (Character c : charStackReversed) {
//            sBuilder.append(c.charValue());
//        }

        return sBuilder.toString();

    }

    public static void main(String[] args) {
        // Example 1:
        String s1 = "bcabc";
        //Output: "abc"

        // Example 2:
        String s2 = "cbacdcbc";
        //Output: "acdb"

        System.out.println(removeDuplicateLetters(s1));
        System.out.println(removeDuplicateLetters(s2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
