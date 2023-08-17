package problems.dsa.days.day3;

public class BinaryTreeCamera {
    public int minCameraCover(TreeNode root) {
        int[] result = dfs(root);
        return Math.min(result[1], result[2]);
    }

    private int[] dfs(TreeNode node) {
        // Base case: If the node is null, return [0, 0, inf].
        if (node == null) {
            return new int[]{0, 0, 999999};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int minCameras = 1 + Math.min(left[1], Math.min(left[2], left[0]))
                + Math.min(right[1], Math.min(right[2], right[0]));

        int notMonitored = Math.min(left[1] + right[1], minCameras);
        int monitoredWithoutCamera = Math.min(left[2] + Math.min(right[1], right[2]),
                right[2] + Math.min(left[1], left[2]));

        return new int[]{notMonitored, monitoredWithoutCamera, minCameras};
    }

    public static void main(String[] args) {
        BinaryTreeCamera solution = new BinaryTreeCamera();

        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(0);
        root1.left.right = new TreeNode(0);
        root1.left.left = new TreeNode(0);

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(0);
        root2.left.left = new TreeNode(0);
        root2.left.left.left = new TreeNode(0);
        root2.left.right = new TreeNode(0);

        System.out.println(solution.minCameraCover(root1));  // Output: 1
        System.out.println(solution.minCameraCover(root2));  // Output: 2
    }
}