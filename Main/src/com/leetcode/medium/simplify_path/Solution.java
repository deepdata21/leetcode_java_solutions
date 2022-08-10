package com.leetcode.medium.simplify_path;

import java.util.Iterator;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    //Given a string path, which is an absolute path (starting with a slash '/') to
    //a file or directory in a Unix-style file system, convert it to the simplified
    //canonical path.
    //
    // In a Unix-style file system, a period '.' refers to the current directory, a
    //double period '..' refers to the directory up a level, and any multiple
    //consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem,
    //any other format of periods such as '...' are treated as file/directory names.
    //
    // The canonical path should have the following format:
    //
    //
    // The path starts with a single slash '/'.
    // Any two directories are separated by a single slash '/'.
    // The path does not end with a trailing '/'.
    // The path only contains the directories on the path from the root directory
    //to the target file or directory (i.e., no period '.' or double period '..')
    //
    //
    // Return the simplified canonical path.
    //
    //
    // Example 1:
    //
    //
    //Input: path = "/home/"
    //Output: "/home"
    //Explanation: Note that there is no trailing slash after the last directory
    //name.
    //
    //
    // Example 2:
    //
    //
    //Input: path = "/../"
    //Output: "/"
    //Explanation: Going one level up from the root directory is a no-op, as the
    //root level is the highest level you can go.
    //
    //
    // Example 3:
    //
    //
    //Input: path = "/home//foo/"
    //Output: "/home/foo"
    //Explanation: In the canonical path, multiple consecutive slashes are replaced
    //by a single one.
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= path.length <= 3000
    // path consists of English letters, digits, period '.', slash '/' or '_'.
    // path is a valid absolute Unix path.
    //
    //
    // Related Topics String Stack 👍 2726 👎 541


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static String simplifyPath(String path) {

        //  Doesn't work with Deque/ArrayDeque
        //      without reversing using Iterator
        Deque<String> componentStack = new ArrayDeque<>();
//        Stack<String> componentStack = new Stack<>();

        String[] pathComponents = path.split("/");

        for (String dir : pathComponents) {
            //  Noting to do for "." or empty string
            if (dir.equals(".") || dir.isEmpty()) {
                continue;
                //  If "..", pop current directory (if not empty)
                //      to go one level up
            } else if (dir.equals("..")) {
                if (!componentStack.isEmpty()) {
                    componentStack.pop();
                }
            } else {
                //  In all other cases add component to stack
                //      as a valid directory
//                componentStack.add(dir);  //  Works with stack
                componentStack.push(dir);   //  Works with Deque
            }
        }

        //  Reverse the stack
        Iterator<String> componentStackReverse = componentStack.descendingIterator();

        //  Build the simplified canonical path
        StringBuilder canonicalPath = new StringBuilder();

            //  Works with Deque only
        while (componentStackReverse.hasNext()) {
            canonicalPath.append("/");
            canonicalPath.append(componentStackReverse.next());
        }
            //  Works with stack only
//        for (String validDir : componentStackReverse) {
//            canonicalPath.append("/");
//            canonicalPath.append(validDir);
//        }

        return canonicalPath.length() > 0 ? canonicalPath.toString() : "/";
    }

    public static void main(String[] args) {
        // Example 1:
        String path1 = "/home/";
        //  O/P: "/home"

        // Example 2:
        String path2 = "/../";
        //  O/P: "/"

        // Example 3:
        String path3 = "/home//foo/";
        //  O/P: "/home/foo"

        System.out.println(simplifyPath(path1));
        System.out.println(simplifyPath(path2));
        System.out.println(simplifyPath(path3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
