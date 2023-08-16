package problems.dsa.days.day2;

public class MagicSquaresInGrid {
    public static int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isMagicSquare(int[][] grid, int row, int col) {
        int[] freq = new int[10];
        int magicConstant = -1;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || freq[num] > 0) {
                    return false;
                }
                freq[num]++;

                if (i == row) {
                    magicConstant = magicConstant == -1 ? num + grid[i][j + 1] + grid[i][j + 2] : magicConstant;
                }
            }

            if (i != row && magicConstant != grid[i][col] + grid[i][col + 1] + grid[i][col + 2]) {
                return false;
            }
        }

        for (int j = col; j < col + 3; j++) {
            if (magicConstant != grid[row][j] + grid[row + 1][j] + grid[row + 2][j]) {
                return false;
            }
        }

        return magicConstant == grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] &&
                magicConstant == grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];
    }

    public static void main(String[] args) {
//        int[][] grid = {
//                {4, 3, 8, 4},
//                {9, 5, 1, 9},
//                {2, 7, 6, 2}
//        };
        int[][] grid = {
                {7, 8, 2, 5},
                {9, 3, 6, 8},
                {9, 5, 1, 9}
        };

        System.out.println(numMagicSquaresInside(grid)); // Output: 1
    }
}
