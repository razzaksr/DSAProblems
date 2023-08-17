package problems.dsa.days.day3;

//O(m + n)
public class BSTsToDLL {
    // Helper function to print a doubly linked list
    public static void printDoublyLinkedList(TreeNode head)
    {
        while (head != null)
        {
            System.out.print(head.data + " —> ");
            head = head.right;
        }
        System.out.println("null");
    }

    // Function to insert a BST TreeNode at the front of a doubly linked list
    public static TreeNode push(TreeNode root, TreeNode head)
    {
        // insert the given TreeNode at the front of a DDL
        root.right = head;

        // update the left child of the existing head TreeNode of the DDL
        // to point to the BST TreeNode
        if (head != null) {
            head.left = root;
        }

        // update the head pointer of DDL
        head = root;
        return head;
    }

    // Recursive function to convert a BST into a doubly-linked list. It takes
    // the BST's root TreeNode and the head TreeNode of the doubly linked list as an argument
    public static TreeNode convertBSTtoDLL(TreeNode root, TreeNode head)
    {
        // Base case
        if (root == null) {
            return head;
        }

        // recursively convert the right subtree
        head = convertBSTtoDLL(root.right, head);

        // push the current TreeNode at the front of the doubly linked list
        head = push(root, head);

        // recursively convert the left subtree
        head = convertBSTtoDLL(root.left, head);

        return head;
    }

    // Recursive function to merge two doubly-linked lists into a
    // single doubly linked list in sorted order
    public static TreeNode mergeDDLs(TreeNode a, TreeNode b)
    {
        // if the first list is empty, return the second list
        if (a == null) {
            return b;
        }

        // if the second list is empty, return the first list
        if (b == null) {
            return a;
        }

        // if the head TreeNode of the first list is smaller
        if (a.data < b.data)
        {
            a.right = mergeDDLs(a.right, b);
            a.right.left = a;
            return a;
        }

        // if the head TreeNode of the second list is smaller
        else {
            b.right = mergeDDLs(a, b.right);
            b.right.left = b;
            return b;
        }
    }

    // Function to merge two binary search trees into a doubly-linked list
    // in sorted order
    public static TreeNode merge(TreeNode a, TreeNode b)
    {
        // convert the first binary search tree into a doubly-linked list
        TreeNode first = null;
        first = convertBSTtoDLL(a, first);

        // convert the second binary search tree into a doubly-linked list
        TreeNode second = null;
        second = convertBSTtoDLL(b, second);

        // merge both doubly-linked lists
        return mergeDDLs(first, second);
    }

    public static void main(String[] args)
    {
        /*
        Construct the first BST
              20
             /  \
            10  30
               /  \
              25  100
        */

        TreeNode a = new TreeNode(20);
        a.left = new TreeNode(10);
        a.right = new TreeNode(30);
        a.right.left = new TreeNode(25);
        a.right.right = new TreeNode(100);
 
        /*
        Construct the second BST
              50
             /  \
            5   70
        */

        TreeNode b = new TreeNode(50);
        b.left = new TreeNode(5);
        b.right = new TreeNode(70);

        // merge both BSTs into a doubly-linked list
        TreeNode root = merge(a, b);
        printDoublyLinkedList(root);
    }
}
