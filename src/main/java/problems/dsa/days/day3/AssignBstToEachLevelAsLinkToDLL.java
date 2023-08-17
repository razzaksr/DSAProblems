package problems.dsa.days.day3;

class Node
{
    int data;
    Node left = null, right = null, next = null;

    Node(int data) {
        this.data = data;
    }
}

public class AssignBstToEachLevelAsLinkToDLL {
    public static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " —> ");
            head = head.next;
        }

        System.out.println("null");
    }

    // Function to perform inorder traversal on a given binary tree where nodes
    // at the same level are linked together in the form of a linked list
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }

        inorder(root.left);

        // print current node and its next node
        System.out.print(root.data + "—>");
        if (root.next != null) {
            System.out.println(root.next.data);
        }
        else {
            System.out.println("null");
        }

        inorder(root.right);
    }

    // Recursive function to find the first node in the next level of a given root node
    public static Node findNextNode(Node root)
    {
        // base case
        if (root == null || root.next == null) {
            return null;
        }

        // if the left child of the root's next node exists, return it
        if (root.next.left != null) {
            return root.next.left;
        }

        // if the right child of the root's next node exists, return it
        if (root.next.right != null) {
            return root.next.right;
        }

        // if root's next node is a leaf node, recur for root's next node
        return findNextNode(root.next);
    }

    // Recursive function to link nodes present in each level of a binary tree
    // in the form of a linked list
    public static void linkNodes(Node root)
    {
        // base case
        if (root == null) {
            return;
        }

        // ensure that the nodes of the current level are linked before the
        // next level nodes
        linkNodes(root.next);

        // Update the next pointer of root's left child to root's right child.
        // If the right child doesn't exist, link it to the first node in the
        // next level.
        if (root.left != null) {
            root.left.next = (root.right != null)? root.right: findNextNode(root);
        }

        // update the next pointer of the root's right child to the first node
        // in the next level
        if (root.right != null) {
            root.right.next = findNextNode(root);
        }

        // recur for the left and right subtree
        linkNodes(root.left);
        linkNodes(root.right);
    }

    public static void main(String[] args)
    {
        /* Construct the following tree
               1
             /   \
            2     3
           / \     \
          4   5     6
           \       /
            7     8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.right = new Node(7);
        root.right.right.left = new Node(8);

        // link nodes at the same level
        linkNodes(root);

        // print the nodes
        Node node = root;
        while (node != null)
        {
            // print the current level
            printList(node);

            // find the leftmost node in the next level
            if (node.left != null) {
                node = node.left;
            }
            else if (node.right != null) {
                node = node.right;
            }
            else {
                node = findNextNode(node);
            }
        }

        // inorder(root);
    }
}
