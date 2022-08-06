package com.leetcode.test;

public class Solution {

/*
    Write a Java Program to count the number of words in a string using HashMap.

    Sample test cases:
    String str = "This this is is done by Saket Saket"
    O/P: {Saket=2, by=1, this=1, This=1, is=2, done=1}

*/
    static void countWords (String str) {

        String[] wordArray = str.split("\\s+");

        java.util.Map<String, Integer> hMap = new java.util.HashMap<>();

        for (int i = 0; i < wordArray.length; i++) {
            if (hMap.containsKey(wordArray[i])) {
                hMap.put(wordArray[i], hMap.get(wordArray[i]) + 1);
            } else {
                hMap.put(wordArray[i], 1);
            }
        }

        for (String word : wordArray) {
            System.out.println(word);
        }
        System.out.println(hMap);
    }

    //  Driver code
    public static void main(String[] args) {
        String str = "This this is is done by Saket Saket";

        countWords(str);
    }

}
