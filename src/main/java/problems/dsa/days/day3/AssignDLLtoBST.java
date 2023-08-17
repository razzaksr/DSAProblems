package problems.dsa.days.day3;

class NodeWrapper
{
    public TreeNode TreeNode;

    NodeWrapper(TreeNode TreeNode) {
        this.TreeNode = TreeNode;
    }
}

public class AssignDLLtoBST {
    public static TreeNode push(TreeNode head, int data)
    {
        // allocate a new TreeNode and link it at the beginning
        TreeNode TreeNode = new TreeNode(data);
        TreeNode.right = head;

        // change `prev` of the existing head TreeNode to point to the new TreeNode
        if (head != null) {
            head.left = TreeNode;
        }

        // update head pointer
        head = TreeNode;
        return head;
    }

    // Function to print and count the total number of nodes in a doubly-linked list
    public static int printAndCountNodes(TreeNode TreeNode)
    {
        int counter = 0;

        while (TreeNode != null)
        {
            System.out.print(TreeNode.data + " ");
            TreeNode = TreeNode.right;
            counter++;
        }

        System.out.println();
        return counter;
    }

    // Function to print preorder traversal of the BST
    public static void preorder(TreeNode root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Recursive function to construct a height-balanced BST from a sorted doubly
    // linked list. It takes a reference to the head TreeNode of the doubly linked
    // list and the total number of nodes in it as an argument
    public static TreeNode convertSortedDLLToBalancedBST(NodeWrapper head, int n)
    {
        // base case
        if (n <= 0) {
            return null;
        }

        // recursively construct the left subtree
        TreeNode leftSubTree = convertSortedDLLToBalancedBST(head, n/2);

        // `head` now points to the middle TreeNode of the sorted DDL

        // make the middle TreeNode of the sorted DDL as the root TreeNode of the BST
        TreeNode root = head.TreeNode;

        // update left child of the root TreeNode
        root.left = leftSubTree;

        // update the head reference of the doubly linked list
        head.TreeNode = head.TreeNode.right;

        // recursively construct the right subtree with the remaining nodes
        root.right = convertSortedDLLToBalancedBST(head, n - (n/2 + 1));
        /* +1 for the root TreeNode */

        // return the root TreeNode
        return root;
    }


    public static void main(String[] args)
    {
        // points to the head of a doubly linked list
        TreeNode head = null;

        // construct a doubly linked list from sorted keys
        int[] keys = { 25, 20, 18, 15, 12, 10, 8 };
        for (int key: keys) {
            head = push(head, key);
        }

        // print the list and count the total number of nodes
        System.out.print("Doubly Linked List: ");
        int n = printAndCountNodes(head);

        // construct a height-balanced BST from a sorted doubly linked list

        // wrap the `head` TreeNode, so its reference can be changed
        TreeNode root = convertSortedDLLToBalancedBST(new NodeWrapper(head), n);

        System.out.print("Preorder traversal of the constructed BST: ");
        preorder(root);
    }
}
