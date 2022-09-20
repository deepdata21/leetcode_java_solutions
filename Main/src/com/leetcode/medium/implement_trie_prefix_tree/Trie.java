package com.leetcode.medium.implement_trie_prefix_tree;

public class Trie {
    //A trie (pronounced as "try") or prefix tree is a tree data structure used to
    //efficiently store and retrieve keys in a dataset of strings. There are various
    //applications of this data structure, such as autocomplete and spellchecker.
    //
    // Implement the Trie class:
    //
    //
    // Trie() Initializes the trie object.
    // void insert(String word) Inserts the string word into the trie.
    // boolean search(String word) Returns true if the string word is in the trie (
    //i.e., was inserted before), and false otherwise.
    // boolean startsWith(String prefix) Returns true if there is a previously
    //inserted string word that has the prefix prefix, and false otherwise.
    //
    //
    //
    // Example 1:
    //
    //
    //Input
    //["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
    //[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
    //Output
    //[null, null, true, false, true, null, true]
    //
    //Explanation
    //Trie trie = new Trie();
    //trie.insert("apple");
    //trie.search("apple");   // return True
    //trie.search("app");     // return False
    //trie.startsWith("app"); // return True
    //trie.insert("app");
    //trie.search("app");     // return True
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= word.length, prefix.length <= 2000
    // word and prefix consist only of lowercase English letters.
    // At most 3 * 10⁴ calls in total will be made to insert, search, and
    //startsWith.
    //
    //
    // Related Topics Hash Table String Design Trie 👍 8176 👎 103

//leetcode submit region begin(Prohibit modification and deletion)
//class Trie {

    static class TrieNode {
        //  Link nodes to root (parent):
        //  Array of TrieNode type
        private TrieNode[] children;

        //  Number of childeren
        //  # of children set to 26, because English alphabet
        private final int N = 26;

        //  Declare a boolean variable to mark the end of word
        boolean isEndofWord;

        //  Create no-argument constructor
        public TrieNode () {
            //  Set children as a TrieNode array
            //      of size N
            children = new TrieNode[N];
        }

        //  Create a TrieNode for a given character c
        public void put (char c, TrieNode node) {
            //  Always subtract the ASCII value of
            //      character/letter 'a' to set the starting index to 0
            //  'a' has an integer value of 97
            //  'z' has an integer value of 122
            //  After subtracting 'a',
            //      a to z are indexed between 0 and 25
            children[c - 'a'] = node;
        }

        //  Check if a given character/letter is present
        public boolean containsKey (char c) {
            return children[c - 'a'] != null;
        }

        //  Retrieve a node for a given character/letter
        public TrieNode get (char c) {
            return children[c - 'a'];
        }

        //  Set the end of word to true
        public void setEndofWord () {
            isEndofWord = true;
        }

        //  Check if it is the end of word
        public boolean isEndofWord () {
            return isEndofWord;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert (String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            //  Check if current node contains current letter (c)
            //  If not, put a node at the current letter
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }

            //  Update the current node
            node = node.get(c);
        }

        node.isEndofWord = true;
    }

    public TrieNode searchHelper (String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }

        return node;
    }

    public boolean search(String word) {
        //  Search the given word
        //      using the searchHelper method
        //      and save the returned node
        TrieNode node = searchHelper(word);

       //   Check if the given word is present
       //   and if isEndOfWord set to true
        return node != null && node.isEndofWord;
    }

    public boolean startsWith(String prefix) {
        //  Search the given prefix
        //      using the searchHelper method
        //      and save the returned node
        TrieNode node = searchHelper(prefix);

        //  Check if the given prefix is present
        return node != null;
    }

    public static void main(String[] args) {
        // Example 1:
        //Input
        //["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
        //[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]

        Trie trie = new Trie();
        //  O/P: null

        trie.insert("apple");
        //  O/P: null

        System.out.println(trie.search("apple"));
        //  O/P: true

        System.out.println(trie.search("app"));
        //  O/P: false

        System.out.println(trie.startsWith("app"));
        //  O/P: true

        trie.insert("app");
        //  O/P: null

        System.out.println(trie.search("app"));
        //  O/P: true

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

