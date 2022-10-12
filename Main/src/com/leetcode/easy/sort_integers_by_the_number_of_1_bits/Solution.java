package com.leetcode.easy.sort_integers_by_the_number_of_1_bits;

import java.util.Arrays;

public class Solution {
    //You are given an integer array arr. Sort the integers in the array in
    //ascending order by the number of 1's in their binary representation and in case of two
    //or more integers have the same number of 1's you have to sort them in ascending
    //order.
    //
    // Return the array after sorting it.
    //
    //
    // Example 1:
    //
    //
    //Input: arr = [0,1,2,3,4,5,6,7,8]
    //Output: [0,1,2,4,8,3,5,6,7]
    //Explantion: [0] is the only integer with 0 bits.
    //[1,2,4,8] all have 1 bit.
    //[3,5,6] have 2 bits.
    //[7] has 3 bits.
    //The sorted array by bits is [0,1,2,4,8,3,5,6,7]
    //
    //
    // Example 2:
    //
    //
    //Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
    //Output: [1,2,4,8,16,32,64,128,256,512,1024]
    //Explantion: All integers have 1 bit in the binary representation, you should
    //just sort them in ascending order.
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= arr.length <= 500
    // 0 <= arr[i] <= 10⁴
    //
    //
    // Related Topics Array Bit Manipulation Sorting Counting 👍 1306 👎 58


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public int[] sortByBits(int[] arr) {
            int lengthArray = arr.length;
        int[] oneBitsArray = new int[lengthArray];

        //  Sort the given array in ascending order
        //      since we have to return elements with
        //      the same number of 1's in the ascending order
        Arrays.sort(arr);

        //  Iterate over the elements of a given array
        //      to count the number of 1's in each (element)_2
        //  Store the number of each element in oneBitsArray
        for (int i = 0; i < lengthArray; i++) {
            //  Declare and initialize the count of 1's
            int countOneBits = 0;

            //  Store the current array element
            int currentElement = arr[i];

            //  Iterative over the all bits in the
            //      binary version of the current element
            //      to count the total number of 1's
            while (currentElement > 0) {
                //  If 1 bit AND with currentElement yields 1
                //      we have a 1, so countOneBits increased by 1
                if ((currentElement & 1) == 1) {
                    countOneBits++;
                }

                //  Once the current bit from the binary version
                //      of current element is processed as above
                //      we get rid of it with the right shift operator,
                //      using >> (by 1 bit only)
                currentElement >>= 1;
            }

            //  Add the current value of countOneBits
            //      as the current element in oneBitsArray
            oneBitsArray[i] = countOneBits;
        }

        //  Declare and initialize the resultArray to be returned
        int[] result = new int[arr.length];

        //  Declare and initialize index for result array to be returned
        int resultIndex = 0;

        //  Declare and initialize maximum number of bits
        //      to be considered
        //  This can be obtained from the contstraints
        //      limiting the size of each element in the given array
        //  There are 14 bits in 10000 (given constraint)
        int maxBits = 14;

        //  Iterate over all bits assuming a maximum possible value
        //      of an element in binary representation
        //  Start from 0 and loop through maxBits
        //      for a maximum of maxBits number of 1's
        for (int i = 0; i < maxBits; i++) {
            //  Now, iterate over the array with the count of 1's
            for (int j = 0; j < oneBitsArray.length; j++) {
                //  If the count of 1's matches with the number of
                //      possible 1's in the binary representation of
                //      of an element in the given array (that is
                //      already sorted in the beginning), then add
                //      this number to the result array to be returned
                if (oneBitsArray[j] == i) {
                    //  Update the result by at current index
                    //      and THEN increase the index by 1;
                    //      hence post-increment
                    result[resultIndex++] = arr[j];
                }
            }
        }

        //  Return the updated array
        return result;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example 1:
        int[] arr = new int[] {0,1,2,3,4,5,6,7,8};

        System.out.println(Arrays.toString(solution.sortByBits(arr)));
        //  O/P: [0,1,2,4,8,3,5,6,7]

        System.out.println();
        // Example 2:
        arr = new int[] {1024,512,256,128,64,32,16,8,4,2,1};

        System.out.println(Arrays.toString(solution.sortByBits(arr)));
        //  O/P: [1,2,4,8,16,32,64,128,256,512,1024]

    }
}
//leetcode submit region end(Prohibit modification and deletion)
