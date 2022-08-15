package com.leetcode.easy.add_binary;

import java.math.BigInteger;

public class Solution {
    //Given two binary strings a and b, return their sum as a binary string.
    //
    //
    // Example 1:
    // Input: a = "11", b = "1"
    //Output: "100"
    //
    // Example 2:
    // Input: a = "1010", b = "1011"
    //Output: "10101"
    //
    //
    // Constraints:
    //
    //
    // 1 <= a.length, b.length <= 10⁴
    // a and b consist only of '0' or '1' characters.
    // Each string does not contain leading zeros except for the zero itself.
    //
    //
    // Related Topics Math String Bit Manipulation Simulation 👍 5625 👎 601

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static String addBinary(String a, String b) {
        //  Approach 1: Might not be acceptable to the interviwer
//        return Integer.toBinaryString(
//                Integer.parseInt(a,2) + Integer.parseInt(b, 2));

        //  Approach 2: XOR a and b (to get respone without carry)
        //      AND a and b and then left shift by 1 (<< 1)
        //          (to get respone with carry)
        //      Set a = the respone without carry
        //      Set b = the respone with carry
        //      Continue while carry != 0

        BigInteger bigA = new BigInteger(a, 2);
        BigInteger bigB = new BigInteger(b, 2);

        BigInteger bigZero = new BigInteger("0", 2);

        BigInteger temp;
        BigInteger carry;

        while (bigB.compareTo(bigZero) != 0) {
            temp = bigA.xor(bigB);
            carry = bigA.and(bigB).shiftLeft(1);

            //  Update bigA
            bigA = temp;
            //  Update bigB
            bigB = carry;
        }

        return bigA.toString(2);
    }

    public static void main(String[] args) {
        // Example 1:
        String a1 = "11";
        String b1 = "1";
        //  O/P: "100"

        // Example 2:
         String a2 = "1010";
         String b2 = "1011";
        //  O/P: "10101"

        System.out.println(addBinary(a1, b1));
        System.out.println(addBinary(a2, b2));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

