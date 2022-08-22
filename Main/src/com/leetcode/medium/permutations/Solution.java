package com.leetcode.medium.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(listOfLists.get(0));
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(3);

        listOfLists.add(list1);
        listOfLists.add(list2);

//        System.out.println(Arrays.deepToString(listOfLists));
        System.out.println(listOfLists);
    }
}