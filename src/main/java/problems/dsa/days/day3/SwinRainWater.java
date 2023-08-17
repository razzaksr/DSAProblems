package problems.dsa.days.day3;

public class SwinRainWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = 0, right = n * n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canReachTarget(grid, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean canReachTarget(int[][] grid, int time) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        return dfs(grid, 0, 0, time, visited);
    }

    public boolean dfs(int[][] grid, int x, int y, int time, boolean[][] visited) {
        int n = grid.length;
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || grid[x][y] > time) {
            return false;
        }
        if (x == n - 1 && y == n - 1) {
            return true;
        }
        visited[x][y] = true;
        return dfs(grid, x + 1, y, time, visited) ||
                dfs(grid, x - 1, y, time, visited) ||
                dfs(grid, x, y + 1, time, visited) ||
                dfs(grid, x, y - 1, time, visited);
    }

    public static void main(String[] args) {
        SwinRainWater solution = new SwinRainWater();

        int[][] grid1 = {{0, 2}, {1, 3}};
        System.out.println(solution.swimInWater(grid1));  // Output: 3

        int[][] grid2 = {{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}};
        System.out.println(solution.swimInWater(grid2));  // Output: 16
    }
}
