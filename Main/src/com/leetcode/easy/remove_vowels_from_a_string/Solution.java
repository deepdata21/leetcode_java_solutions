package com.leetcode.easy.remove_vowels_from_a_string;

import java.util.Set;
import java.util.HashSet;

public class Solution {
//Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and
//return the new string.
//
//
// Example 1:
//
//
//Input: s = "leetcodeisacommunityforcoders"
//Output: "ltcdscmmntyfrcdrs"
//
//
// Example 2:
//
//
//Input: s = "aeiou"
//Output: ""
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s consists of only lowercase English letters.
//
//
// Related Topics String 👍 275 👎 104

    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
    static String removeVowels(String s) {

        //  Approach # 1 (Dumbest)
//        String s_no_a = s.replaceAll("a", "");
//        String s_no_ae = s_no_a.replaceAll("e", "");
//        String s_no_aei = s_no_ae.replaceAll("i", "");
//        String s_no_aeio = s_no_aei.replaceAll("o", "");
//        String s_no_vowels = s_no_aeio.replaceAll("u", "");
//        return s_no_vowels;

        //  Approach # 2 (Dumber)
//        String s_no_vowels = s.replaceAll("[aeiou]", "");
//        return s_no_vowels;

        //  Approach # 3 (Dumb)
        return s.replaceAll("[aeiou]", "");

        //  Approach # 4 (Using HashSet)
//        Set<Character> vowels = new HashSet<>();
//
//        vowels.add('a');
//        vowels.add('e');
//        vowels.add('i');
//        vowels.add('o');
//        vowels.add('u');
//
//        StringBuilder result = new StringBuilder();
//
//        for (char c : s.toCharArray()) {
//            if (!vowels.contains(c)) {
//                result.append(c);
//            }
//        }
//
//        return String.valueOf(result);
    }

//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {

        // Example 1:
        String s1 = "leetcodeisacommunityforcoders";
        //  O/P: "ltcdscmmntyfrcdrs"

        // Example 2:
        String s2 = "aeiou";
        //  O/P: ""

        String s3 = "welcome to the java world";
        //  O/P: wlcm t th jv wrld

        //  Approach # 0 (Dumb 2)
//        System.out.println(s3.replaceAll("[aeiou]", ""));

        System.out.println(removeVowels(s1));
        System.out.println(removeVowels(s2));
        System.out.println(removeVowels(s3));

    }
}
