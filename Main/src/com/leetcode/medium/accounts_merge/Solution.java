package com.leetcode.medium.accounts_merge;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
    //Given a list of accounts where each element accounts[i] is a list of strings,
    //where the first element accounts[i][0] is a name, and the rest of the elements
    //are emails representing emails of the account.
    //
    // Now, we would like to merge these accounts. Two accounts definitely belong
    //to the same person if there is some common email to both accounts. Note that even
    //if two accounts have the same name, they may belong to different people as
    //people could have the same name. A person can have any number of accounts initially,
    //but all of their accounts definitely have the same name.
    //
    // After merging the accounts, return the accounts in the following format: the
    //first element of each account is the name, and the rest of the elements are
    //emails in sorted order. The accounts themselves can be returned in any order.
    //
    //
    // Example 1:
    //
    //
    //Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],[
    //"John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John",
    //"johnnybravo@mail.com"]]
    //Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.
    //com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
    //Explanation:
    //The first and second John's are the same person as they have the common email
    //"johnsmith@mail.com".
    //The third John and Mary are different people as none of their email addresses
    //are used by other accounts.
    //We could return these lists in any order, for example the answer [['Mary',
    //'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
    //['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']]
    //would still be accepted.
    //
    //
    // Example 2:
    //
    //
    //Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin",
    //"Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co",
    //"Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@
    //m.co","Fern1@m.co","Fern0@m.co"]]
    //Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.
    //co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.
    //co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co",
    //"Fern1@m.co","Fern5@m.co"]]
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= accounts.length <= 1000
    // 2 <= accounts[i].length <= 10
    // 1 <= accounts[i][j].length <= 30
    // accounts[i][0] consists of English letters.
    // accounts[i][j] (for j > 0) is a valid email.
    //
    //
    // Related Topics Array String Depth-First Search Breadth-First Search Union
    //Find 👍 4803 👎 846

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        //  Approach #1: Using Disjoint Set or Union-Find Data Structure
        /* *** *** *** *** *** Approach #1 Starts *** *** *** *** */

        //  Declare a HashMap to store the names as values
        //      correspoding to the first email in each list as the key
        Map<String, String> emailsToNames = new HashMap<>();

        //  Declare a HashMap to set all emails (keys)
        //      as their own parents/roots (values)
        Map<String, String> emailsToParentEmails = new HashMap<>();

        //  Declare a HashMap to store the combined list of all emails
        //      using union between email lists (hence TreeSet as values)
        Map<String, TreeSet<String>> emailToEmailUnions = new HashMap<>();

        //  Iterate over the lists of accounts to update
        //      the emailsToNames and emailsToParentEmails maps
        for (List<String> a : accounts) {
            //  Also, iterate over all emails in each account
            //  Index starts from 1 to skip the name
            for (int email = 1; email < a.size(); email++) {
                //  Map all emails (keys) to the name (value)
                emailsToNames.put(a.get(email), a.get(0));
                //  Map each email as its own parent/root
                emailsToParentEmails.put(a.get(email), a.get(email));
            }
        }

        //  Iterate over the lists of accounts to agin update
        //      emailsToParentEmails map
        for (List<String> a : accounts) {
            //  Find the parent of the first email in the current list
            String parentEmail = find(a.get(1), emailsToParentEmails);
            //  Also, iterate over all emails in each account
            //  Index starts from 2 to skip the name
            //      and the first email in the given list
            for (int email = 2; email < a.size(); email++) {
                //  Set current parentEmail as the value
                //      (parent) of all remaining emails (keys)
                emailsToParentEmails.put(
                        //  Use the find method
                        //      to find the parents of all remaining emails
                        //      in the current list/account
                        find(a.get(email), emailsToParentEmails),
                        parentEmail);
            }
        }

        //  Iterate over the lists of accounts to perform
        //      unions between email lists using TreeSet
        //      (TreeSet to list emails in sorted order)
        for(List<String> a : accounts) {
            //  Find the parent of the first email in the current list
            String parentEmail = find(a.get(1), emailsToParentEmails);
            //  Check if the emailToEmailUnions map already has the
            //      parentEmail as a key, if not put it in the map
            //      along with a new empty TreeSet as the value
            if(!emailToEmailUnions.containsKey(parentEmail)) {
                emailToEmailUnions.put(parentEmail, new TreeSet<>());
            }
            //  Iterate over all emails in the current list/account
            for (int email = 1; email < a.size(); email++) {
                //  Get access to the newly created or already existing TreeSet
                //      passed on as a value corresponding to the parentEmail
                //      key in the emailToEmailUnions map,
                //      and add the current email to this TreeSet
                //      to build the mergedAccounts list only with emails
                emailToEmailUnions.get(parentEmail).add(a.get(email));
            }
        }

        //  Declare a list of lists to store all the merged accounts
        List<List<String>> mergedAccountsList = new ArrayList<>();

        //  Iterate over all keys from the emailToEmailUnions map
        for (String email: emailToEmailUnions.keySet()) {
            //  Declare a new list and initialize with the TreeSet
            //      obtained using emailToEmailUnions.get(email)
            List<String> mergedAccounts = new ArrayList<>(emailToEmailUnions.get(email));

            //  Add the name (from the emailsToNames map)
            //      corresponding to the current email
            //      as the first element of the merged accounts list
            mergedAccounts.add(0, emailsToNames.get(email));
            //  Add the current list of merged accounts
            //      to the output list of lists
            mergedAccountsList.add(mergedAccounts);
        }
        //  return the list of merged accounts
        return mergedAccountsList;
    }

     //  Implement the find method to find
     //     the parent email of a given email from a given list
    private static String find(String email, Map<String, String> map) {
        //  Using a ternary operation that checks the equality
        //      between the given emailsToParentEmails map
        //          and the given string
        //      return the given string if conditon true
        //      or make recursive calls to the same find method
        //          if conditon false
        return map.get(email) == email ? email : find(map.get(email), map);
    }
    /* *** *** *** *** *** Approach #1 Ends *** *** *** *** *** */

    public static void main(String[] args) {

        // Example 1:
        List<List<String>> accounts = List.of (
                List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
                List.of("John","johnsmith@mail.com","john00@mail.com"),
                List.of("Mary","mary@mail.com"),
                List.of("John","johnnybravo@mail.com")
        );

        System.out.println(accountsMerge(accounts));
        //Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.
        //com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]

        System.out.println("-------------------");
        // Example 2:
        accounts = List.of (
                List.of("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"),
                List.of("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"),
                List.of("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"),
                List.of("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"),
                List.of("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co")
        );

        System.out.println(accountsMerge(accounts));
        //Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.
        //co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.
        //co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co",
        //"Fern1@m.co","Fern5@m.co"]]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

