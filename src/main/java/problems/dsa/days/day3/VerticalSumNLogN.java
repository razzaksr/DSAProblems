package problems.dsa.days.day3;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSumNLogN {
    public static void printVerticalSum(TreeNode root, int dist, Map<Integer, Integer> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }

        // update the map
        map.put(dist, map.getOrDefault(dist, 0) + root.data);

        // recur for the left subtree by decreasing horizontal distance by 1
        printVerticalSum(root.left, dist - 1, map);

        // recur for the right subtree by increasing horizontal distance by 1
        printVerticalSum(root.right, dist + 1, map);
    }

    // Function to print the vertical sum of a given binary tree
    public static void printVerticalSum(TreeNode root)
    {
        // create an empty `TreeMap` where
        // key —> relative horizontal distance of the TreeNode from the root TreeNode, and
        // value —> sum of all nodes present at the same horizontal distance
        Map<Integer, Integer> map = new TreeMap<>();

        // perform preorder traversal on the tree and fill the map
        printVerticalSum(root, 0, map);

        // print vertical sum
        System.out.println(map.values());
    }

    public static void main(String[] args)
    {
        /* Construct the following tree
                1
              /   \
             /     \
            2       3
                  /   \
                 /     \
                5       6
              /   \
             /     \
            7       8
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        printVerticalSum(root);
    }
}
