package problems.dsa.days.day3;

public class AssignGoldMaxPath {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }

        return maxGold;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        int originalValue = grid[row][col];
        grid[row][col] = 0; // Mark the cell as visited

        int maxGold = 0;
        int[] rowOffsets = {-1, 1, 0, 0};
        int[] colOffsets = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];
            maxGold = Math.max(maxGold, dfs(grid, newRow, newCol));
        }

        grid[row][col] = originalValue; // Restore the cell's value

        return maxGold + originalValue;
    }

    public static void main(String[] args) {
        AssignGoldMaxPath solution = new AssignGoldMaxPath();
        int[][] grid = {
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };
        System.out.println(solution.getMaximumGold(grid)); // Output: 24
        int[][] grid1 = {
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };
        System.out.println(solution.getMaximumGold(grid1)); // Output: 24
        int[][] grid2 = {
                {1, 0, 7},
                {2, 0, 6},
                {3, 4, 5},
                {0, 3, 0},
                {9, 0, 20}
        };
        System.out.println(solution.getMaximumGold(grid2)); // Output: 28
        int[][] grid3 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println(solution.getMaximumGold(grid3)); // Output: 0

        int[][] grid4 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(solution.getMaximumGold(grid4)); // Output: 45
    }
}
