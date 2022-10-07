package com.leetcode.medium.word_search;

public class Solution {
    //Given an m x n grid of characters board and a string word, return true if
    //word exists in the grid.
    //
    // The word can be constructed from letters of sequentially adjacent cells,
    //where adjacent cells are horizontally or vertically neighboring. The same letter
    //cell may not be used more than once.
    //
    //
    // Example 1:
    //
    //
    //Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
    // "ABCCED"
    //Output: true
    //
    //
    // Example 2:
    //
    //
    //Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
    // "SEE"
    //Output: true
    //
    //
    // Example 3:
    //
    //
    //Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
    // "ABCB"
    //Output: false
    //
    //
    //
    // Constraints:
    //
    //
    // m == board.length
    // n = board[i].length
    // 1 <= m, n <= 6
    // 1 <= word.length <= 15
    // board and word consists of only lowercase and uppercase English letters.
    //
    //
    //
    // Follow up: Could you use search pruning to make your solution faster with a
    //larger board?
    //
    // Related Topics Array Backtracking Matrix 👍 11079 👎 425


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {

    /**
     * TIME COMPLEXITY: O(n 3^l) where n is the number of grid cells and
     *      l is the length of the given word
     * SPACE COMPLEXITY: O(l) where l is the length of the given word
     *
     * STEPS
     * ---------------------
     * 1. Begin the search with the first character of the given word;
     *      that is, from index 0 as in word.chaAt(0)
     * 2. Using a backtrackHelper function:
     *      2.1 Check base cases #1, #2, and #3 (see code below)
     *      2.2. Search horizontally (in 2 directions) and
     *          vertically (in 2 more directions);
     *          however, 3 directions in total in each iteration
     *          since sequential and not moving back to the starting point
     *
     * 3. Declare a boolean flag to return and
     *      mark place '0' in the current cell to mark it as visited
     * 4. Finally, return the flag
     */

    //  Grid of characters
    private char[][] board;
    //  Length of rows
    private int rowLength;
    //  Length of columns
    private int colLength;

    /**
     * @param board given grid of characters
     * @param word  given word
    */
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rowLength = board.length;
        this.colLength = board[0].length;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                //  index = 0 since starting from
                //      the beginning of the word every time
                if (this.backtrackHelper(row, col, word, 0)) {
                    return true;
                }
            }
        }

        //  return false if word not found
        return false;
    }

    /**
     * @param r     row #
     * @param c     column #
     * @param w     given word
     * @param idx   index as in word.charAt(index)
    */
    private boolean backtrackHelper (int r, int c, String w, int idx) {

        //  Check base case #1:
        //      return true if current index
        //      is equal to the length of the word
        if (idx == w.length()) {
            return true;
        }

        //  Check base case #2:
        //      return false if row or colum #
        //      falls behind the bounadaries
        if (r < 0 || r == this.rowLength || c < 0 || c == this.colLength) {
            return false;
        }

        //  Check base case #3:
        //      return false if the first character of the given
        //      word is not the same as the one in the current cell
        if (this.board[r][c] != w.charAt(idx)) {
            return false;
        }

        //  Declare a boolean flag and initialize it with false
        boolean flag = false;

        //  Mark the visited cell with an arbitrary value,
        //      for example = 0;
        this.board[r][c] = '0';

        //  Declare a 2D direction matrix
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        //  Iterate over the possible directions
        for (int[] d : directions) {
            flag = this.backtrackHelper(r + d[0],
                                        c + d[1],
                                        w, idx + 1);

            if(flag) {
                break;
            }
        }

        //  Update the current cell by replacing 0 with
        //      the original character
        this.board[r][c] = w.charAt(idx);
        return flag;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1:
        char[][] board1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word1 = "ABCCED";
        System.out.println(solution.exist(board1, word1));
        //  O/P: true

        System.out.println();
        // Example 2:
        char[][] board2 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word2 = "SEE";
        //  O/P: true
        System.out.println(solution.exist(board2, word2));

        System.out.println();
        // Example 3:
        char[][] board3 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word3 = "ABCB";

        System.out.println(solution.exist(board3, word3));
        //  O/P: false
    }
}
//leetcode submit region end(Prohibit modification and deletion)
