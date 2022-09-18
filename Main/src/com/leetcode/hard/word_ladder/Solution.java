package com.leetcode.hard.word_ladder;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    //A transformation sequence from word beginWord to word endWord using a
    //dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
    //
    //
    //
    // Every adjacent pair of words differs by a single letter.
    // Every si for 1 <= i <= k is in wordList. Note that beginWord does not need
    //to be in wordList.
    // sk == endWord
    //
    //
    // Given two words, beginWord and endWord, and a dictionary wordList, return
    //the number of words in the shortest transformation sequence from beginWord to
    //endWord, or 0 if no such sequence exists.
    //
    //
    // Example 1:
    //
    //
    //Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
    //"lot","log","cog"]
    //Output: 5
    //Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -
    //> "dog" -> cog", which is 5 words long.
    //
    //
    // Example 2:
    //
    //
    //Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
    //"lot","log"]
    //Output: 0
    //Explanation: The endWord "cog" is not in wordList, therefore there is no
    //valid transformation sequence.
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= beginWord.length <= 10
    // endWord.length == beginWord.length
    // 1 <= wordList.length <= 5000
    // wordList[i].length == beginWord.length
    // beginWord, endWord, and wordList[i] consist of lowercase English letters.
    // beginWord != endWord
    // All the words in wordList are unique.
    //
    //
    // Related Topics Hash Table String Breadth-First Search 👍 9044 👎 1719


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //  Approach from LC Discussions Post
        //  Time Complexity: O(M^2 * N)
        //  Space Complexity: O(M * N)

        //  Declare a set to contain the words
        //      from the given word list
        Set<String> wordListSet = new HashSet<>(wordList);

        //  Return 0 if the endWord is not in the wordListSet
        if (!wordListSet.contains(endWord)) {
            return 0;
        }

        //  Declare a queue for BFS
        //      which gives the minimum distance required
        Queue<String> bfsQueue = new LinkedList<>();
        //  Initialize it with the beginWord
        bfsQueue.add(beginWord);

        //  Declare a set to keep track of visited words
        Set<String> visitedWords = new HashSet<>();
        //  Initialize it with the beginWord
        visitedWords.add(beginWord);

        //  Declare the length of the transformation sequence
        //      and initialize it with 1
        //      (since always has the beginWord)
        int sequenceLength = 1;

        //
        while (!bfsQueue.isEmpty()) {
            //  Store the original queueSize for current iteration
            int queueSize = bfsQueue.size();
            for (int i = 0; i < queueSize; i++) {
                String currentWord = bfsQueue.poll();

                if (currentWord.equals(endWord)) {
                    return sequenceLength;
                }

                for (int j = 0; j < currentWord.length(); j++) {
                    //  Iterate over all letters in the alphabet
                    //      to replace one letter in the word,
                    //      and check if it is present in the given word list
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] wordCharArray = currentWord.toCharArray();
                        //  Replace a character in the current word
                        //      defined as a character array
                        wordCharArray[j] = c;

                        //  Define a new word using the updated
                        //      character array
                        String newWord = new String(wordCharArray);

                        //  If the new word is in the given list and
                        //      has not already been visited,
                        //      add it to the bfsQueue and
                        //      visitedWords hash set
                        if (wordListSet.contains(newWord) &&
                                !visitedWords.contains(newWord)) {
                            bfsQueue.add(newWord);
                            visitedWords.add(newWord);
                        }
                    }
                }
            }
            sequenceLength++;
        }

        //  Return 0 in absence of a sequence
        return 0;
    }

    public static void main(String[] args) {
        // Example 1:
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = List.of("hot","dot","dog","lot","log","cog");
        //  O/P: 5

        // Example 2:
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = List.of("hot","dot","dog","lot","log");
        //  O/P: 0

        // Example 3:
        String beginWord3 = "red";
        String endWord3 = "tax";
        List<String> wordList3 = List.of("ted","tex","red","tax","tad","den","rex","pee");
        //  O/P: 4

        System.out.println(ladderLength(beginWord1, endWord1, wordList1));
        System.out.println(ladderLength(beginWord2, endWord2, wordList2));
        System.out.println(ladderLength(beginWord3, endWord3, wordList3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
