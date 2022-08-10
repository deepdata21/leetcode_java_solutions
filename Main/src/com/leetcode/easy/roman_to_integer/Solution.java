package com.leetcode.easy.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //Roman numerals are represented by seven different symbols: I, V, X, L, C, D
    //and M.
    //
    //
    //Symbol       Value
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    //
    // For example, 2 is written as II in Roman numeral, just two ones added
    //together. 12 is written as XII, which is simply X + II. The number 27 is written as
    //XXVII, which is XX + V + II.
    //
    // Roman numerals are usually written largest to smallest from left to right.
    //However, the numeral for four is not IIII. Instead, the number four is written as
    //IV. Because the one is before the five we subtract it making four. The same
    //principle applies to the number nine, which is written as IX. There are six
    //instances where subtraction is used:
    //
    //
    // I can be placed before V (5) and X (10) to make 4 and 9.
    // X can be placed before L (50) and C (100) to make 40 and 90.
    // C can be placed before D (500) and M (1000) to make 400 and 900.
    //
    //
    // Given a roman numeral, convert it to an integer.
    //
    //
    // Example 1:
    //
    //
    //Input: s = "III"
    //Output: 3
    //Explanation: III = 3.
    //
    //
    // Example 2:
    //
    //
    //Input: s = "LVIII"
    //Output: 58
    //Explanation: L = 50, V= 5, III = 3.
    //
    //
    // Example 3:
    //
    //
    //Input: s = "MCMXCIV"
    //Output: 1994
    //Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= s.length <= 15
    // s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
    // It is guaranteed that s is a valid roman numeral in the range [1, 3999].
    //
    //
    // Related Topics Hash Table Math String 👍 5674 👎 354

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int romanToInt(String s) {

        Map<String, Integer> valuesMap = new HashMap<>();

        valuesMap.put("M", 1000);
        valuesMap.put("D", 500);
        valuesMap.put("C", 100);
        valuesMap.put("L", 50);
        valuesMap.put("X", 10);
        valuesMap.put("V", 5);
        valuesMap.put("I", 1);

        int index = 0;
        int totalSum = 0;

        while (index < s.length()) {

            String currentSymbol = s.substring(index, index +1);
            int currentValue = valuesMap.get(currentSymbol);

            int nextValue = 0;

            if (index < s.length() - 1) {
                String nextSymbol = s.substring(index + 1, index + 2);
                nextValue = valuesMap.get(nextSymbol);
            }

            if (currentValue < nextValue) {
                totalSum += (nextValue - currentValue);
                index += 2;
            } else {
                totalSum += currentValue;
                index += 1;
            }
        }
       return totalSum;
    }

    public static void main(String[] args) {

        // Example 1:
        String s1 = "III";
        //  O/P: 3

        // Example 2:
        String s2 = "LVIII";
        //  O/P: 58

        // Example 3:
        String s3 = "MCMXCIV";
        //  O/P: 1994

        System.out.println(romanToInt(s1));
        System.out.println(romanToInt(s2));
        System.out.println(romanToInt(s3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
