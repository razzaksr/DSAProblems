package problems.dsa.days.day3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerialization {
    // Serialization
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X"; // Null marker
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.data + "," + left + "," + right;
    }

    // Deserialization
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("X")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper(queue);
        node.right = helper(queue);
        return node;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        BinaryTreeSerialization serializer = new BinaryTreeSerialization();

        String serialized = serializer.serialize(root);
        System.out.println("Serialized tree: " + serialized);

        TreeNode deserializedRoot = serializer.deserialize(serialized);
        System.out.println("Deserialized tree: " + serializer.serialize(deserializedRoot));
    }
}
