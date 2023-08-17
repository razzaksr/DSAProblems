package problems.dsa.days.day3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class AssignBstSpiralToDLL {
    // Helper function to print a doubly linked list
    public static void printDoublyLinkedList(TreeNode TreeNode)
    {
        while (TreeNode != null)
        {
            System.out.print(TreeNode.data + " —> ");
            TreeNode = TreeNode.right;
        }
        System.out.println("null");
    }

    // Insert a tree TreeNode at the front of the doubly linked list
    public static TreeNode push(TreeNode TreeNode, TreeNode head)
    {
        // initialize head pointer of the doubly linked list
        if (head == null)
        {
            head = TreeNode;
            head.left = head.right = null;
            return head;
        }

        // insert the given TreeNode at the front of the doubly linked list
        head.left = TreeNode;
        TreeNode.right = head;

        // update left child pointer to be null
        TreeNode.left = null;

        // update head pointer to point to the given TreeNode
        head = TreeNode;
        return head;
    }

    // Traverse the tree in a preorder fashion and store nodes in a map
    // corresponding to their level
    public static void preorder(TreeNode root, int level, Map<Integer, Deque<TreeNode>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }

        // insert the current TreeNode and its level into the map
        map.putIfAbsent(level, new ArrayDeque<>());

        // if the level is odd, insert at front; otherwise, search at the back
        if ((level & 1) == 1) {
            map.get(level).addFirst(root);
        }
        else {
            map.get(level).addLast(root);
        }

        // recur for the left and right subtree with a level increased by 1
        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }

    // Recursive function to convert a binary tree into a doubly-linked list
    // using hashing
    public static void convert(TreeNode root)
    {
        // create an empty map to store nodes between given levels
        Map<Integer, Deque<TreeNode>> map = new HashMap<>();

        // traverse the tree and insert its nodes into the map
        // corresponding to their level
        preorder(root, 0, map);

        // iterate through the map in decreasing order of level and
        // push nodes of each level into the doubly linked list
        int n = map.size();
        TreeNode head = null;
        for (int i = n - 1; i >=0; i--)
        {
            for (TreeNode TreeNode: map.get(i)) {
                head = push(TreeNode, head);
            }
        }
    }

    public static void main(String[] args)
    {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              / \     / \
             /   \   /   \
            4     5 6     7
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        convert(root);
        printDoublyLinkedList(root);
    }
}
