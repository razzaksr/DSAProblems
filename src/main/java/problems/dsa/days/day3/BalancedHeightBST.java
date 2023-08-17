package problems.dsa.days.day3;

import java.util.ArrayList;
import java.util.List;

class TreeNode
{
    int data;
    TreeNode left, right;

    // Constructor
    TreeNode(int data) {
        this.data = data;
    }
}
// O(n)
public class BalancedHeightBST {
    public static void preorder (TreeNode root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Recursive function to push nodes of a given binary search tree into a
    // list in an inorder fashion
    public static void pushTreeNodes(TreeNode root, List<TreeNode> nodes)
    {
        // base case
        if (root == null) {
            return;
        }

        pushTreeNodes(root.left, nodes);
        nodes.add(root);
        pushTreeNodes(root.right, nodes);
    }

    // Recursive function to construct a height-balanced BST from
    // given nodes in sorted order
    public static TreeNode buildBalancedBST(List<TreeNode> nodes, int start, int end)
    {
        // base case
        if (start > end) {
            return null;
        }

        // find the middle index
        int mid = (start + end) / 2;

        // The root TreeNode will be a TreeNode present at the mid-index
        TreeNode root = nodes.get(mid);

        // recursively construct left and right subtree
        root.left = buildBalancedBST(nodes, start, mid - 1);
        root.right = buildBalancedBST(nodes, mid + 1, end);

        // return root TreeNode
        return root;
    }

    // Function to construct a height-balanced BST from an unbalanced BST
    public static TreeNode constructBalancedBST(TreeNode root)
    {
        // Push nodes of a given binary search tree into a list in sorted order
        List<TreeNode> nodes = new ArrayList<>();
        pushTreeNodes(root, nodes);

        // Construct a height-balanced BST from sorted BST nodes
        return buildBalancedBST(nodes, 0, nodes.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(15);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(5);
        root.left.left.left.left = new TreeNode(2);
        root.left.left.left.right = new TreeNode(8);

        root = constructBalancedBST(root);

        System.out.print("Preorder traversal of the constructed BST is ");
        preorder(root);
    }
}
