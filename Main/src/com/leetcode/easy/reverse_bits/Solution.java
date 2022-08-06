package com.leetcode.easy.reverse_bits;

// Doesn't work with negative signed integer

public class Solution {
    //Reverse bits of a given 32 bits unsigned integer.
    //
    // Note:
    //
    //
    // Note that in some languages, such as Java, there is no unsigned integer type.
    // In this case, both input and output will be given as a signed integer type.
    //They should not affect your implementation, as the integer's internal binary
    //representation is the same, whether it is signed or unsigned.
    // In Java, the compiler represents the signed integers using 2's complement
    //notation. Therefore, in Example 2 above, the input represents the signed integer -3
    // and the output represents the signed integer -1073741825.
    //
    //
    //
    // Example 1:
    //
    //
    //Input: n = 00000010100101000001111010011100
    //Output:    964176192 (00111001011110000010100101000000)
    //Explanation: The input binary string 00000010100101000001111010011100
    //represents the unsigned integer 43261596, so return 964176192 which its binary
    //representation is 00111001011110000010100101000000.
    //
    //
    // Example 2:
    //
    //
    //Input: n = 11111111111111111111111111111101
    //Output:   3221225471 (10111111111111111111111111111111)
    //Explanation: The input binary string 11111111111111111111111111111101
    //represents the unsigned integer 4294967293, so return 3221225471 which its binary
    //representation is 10111111111111111111111111111111.
    //
    //
    //
    // Constraints:
    //
    //
    // The input must be a binary string of length 32
    //
    //
    //
    // Follow up: If this function is called many times, how would you optimize it?
    //
    //
    // Related Topics Divide and Conquer Bit Manipulation 👍 3362 👎 866


    //leetcode submit region begin(Prohibit modification and deletion)
//public class Solution {
    // you need treat n as an unsigned value
//    static long reverseBits(long n) {
    static int reverseBits(int n) {
        //   If n is 0 return 0
        if (n == 0) {
            return 0;
        }

        //   Initializing the result
        int result = 0;

        //   Loop through the given 32 bit (unsigned) integer
        for (int i = 0; i < 32; i++) {
            //  Bitwise leftshifting result
            result <<= 1;
            //  Adding 1 to result if & between righmost value of n
            //      and 1 is 1
            if ((n & 1) == 1) {
                result++;
            }

            //   Bitwise righshifting given n since the rightmost digit
            //       has been processed
            n >>= 1;
        }

        return result;

    }

    public static void main(String[] args) {

        // Example 1:
//        int n1 = 00000010100101000001111010011100;
        int n1 = 0B00000010100101000001111010011100;
        //  O/P: 964176192 (00111001011110000010100101000000)
        //                 (111001011110000010100101000000)

        // Example 2:
//        int n2 = 11111111111111111111111111111101;
        //  Wrong since left-most 1 represents negative
        //  int n2 = 0B11111111111111111111111111111101;
        //  First, flip 1's and 0's: to get 1's complement
        //  0B00000000000000000000000000000010;
        //  Then add 1: to get 2's complement
        //  0B00000000000000000000000000000011;
        //  So, we have:
//        long n2 = 0B00000000000000000000000000000011L;
        //  O/P: 3221225471 (10111111111111111111111111111111)

        System.out.println(reverseBits(n1));
        System.out.println(Integer.toBinaryString(reverseBits(n1)));
//        System.out.println(reverseBits(n2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

