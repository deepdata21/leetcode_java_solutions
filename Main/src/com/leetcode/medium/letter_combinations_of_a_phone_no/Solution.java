package com.leetcode.medium.letter_combinations_of_a_phone_no;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Solution {
    //Given a string containing digits from 2-9 inclusive, return all possible
    //letter combinations that the number could represent. Return the answer in any order.
    //
    //
    // A mapping of digits to letters (just like on the telephone buttons) is given
    //below. Note that 1 does not map to any letters.
    //
    //
    // Example 1:
    //
    //
    //Input: digits = "23"
    //Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    //
    //
    // Example 2:
    //
    //
    //Input: digits = ""
    //Output: []
    //
    //
    // Example 3:
    //
    //
    //Input: digits = "2"
    //Output: ["a","b","c"]
    //
    //
    //
    // Constraints:
    //
    //
    // 0 <= digits.length <= 4
    // digits[i] is a digit in the range ['2', '9'].
    //
    //
    // Related Topics Hash Table String Backtracking 👍 12576 👎 755

    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {

    //  Decrlare a list of strings
    //      to return all the letter combinations
    //  Each element in the ArrayList =
    //      a possible letter combination
    private static List<String> resultList = new ArrayList<>();

    //  Declare a hashmap
    //      to store the letter combinations (strings, as values)
    //      for correspoding digits (characters, as keys)
    private static Map<Character, String> letterMap = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    //  Declare a string (to store a given digit)
    //     that can be accessed from a helper function
    private static String digitsString;

    //  Create a helper function to make recursive calls and backtrack
    private static void backtrackHelper(int index, StringBuilder combination) {

        //  Backtrack to the loop immediately following the recursive method call
        //      if a proper combination is found
        //      (after adding the combination to the output list)
        if (combination.length() == digitsString.length()) {
            resultList.add(combination.toString());
            return;
        }

        //  Declare and store letters from the letterMap
        //      for a given key obtained from
        //      getting the digit at a given index
        String letters = letterMap.get(digitsString.charAt(index));

        //  for-each loop to iterate through all the letters in
        //      the string "letters"
        for (char c : letters.toCharArray()) {
            combination.append(c);

            //  Make a recursive call
            backtrackHelper(++index, combination);

            //  Return back from inside the if loop with the condition:
            //      (combination.length() == digitsString.length())
            //  Backtrack by deleting the last character/letter
            //      in the current combination
            combination.deleteCharAt(combination.length() - 1);

            //  Also, update the index to for backtracking
            //      by subtracting 1 from the current index
            index--;
        }

    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return resultList;
        }

        digitsString = digits;
        backtrackHelper(0, new StringBuilder());

        return resultList;
    }

    public static void main(String[] args) {
        // Example 1:
        String digits1 = "23";
        //  O/P: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        // Example 2:
        String digits2 = "";
        //  O/P: []

        // Example 3:
        String digits3 = "2";
        //  O/P: ["a","b","c"]

        // Example 4:
        String digits4 = "2345";
        //  INCORRECT - O/P: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

//        System.out.println(letterCombinations(digits1));
//        System.out.println(letterCombinations(digits2));
//        System.out.println(letterCombinations(digits3));
        System.out.println(letterCombinations(digits4));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
