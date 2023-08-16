package problems.dsa.days.day2;

public class DoIsBTreeIsComplete {
    static class Node
    {
        int key;
        Node left = null, right = null;

        Node(int key) {
            this.key = key;
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
            4   5   6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        if (isComplete(root, 0, size(root))) {
            System.out.println("Complete binary tree");
        }
        else {
            System.out.println("Not a complete binary tree");
        }
    }
    private static int size(Node root)
    {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    // Recursive function to check if a given binary tree is a complete tree or not
    public static boolean isComplete(Node root, int i, int n)
    {
        // return if the tree is empty
        if (root == null) {
            return true;
        }

        if ((root.left != null && 2*i + 1 >= n) ||
                !isComplete(root.left, 2*i + 1, n)) {
            return false;
        }

        if ((root.right != null && 2*i + 2 >= n) ||
                !isComplete(root.right, 2*i + 2, n)) {
            return false;
        }

        return true;
    }
}
