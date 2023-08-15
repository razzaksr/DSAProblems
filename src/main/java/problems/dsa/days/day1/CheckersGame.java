package problems.dsa.days.day1;

import java.util.Arrays;

public class CheckersGame {
    public static int maxCellsCaptured(int[][] gameBoard) {
        int n = gameBoard.length;
        int m = gameBoard[0].length;
        int[][] maheshCaptured = new int[n][m];
        int[][] sureshCaptured = new int[n][m];
        // mahesh check down and right direction from the current
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (gameBoard[i][j] == 1) {
                    maheshCaptured[i][j] = 1 + Math.max(
                            i + 1 < n ? maheshCaptured[i + 1][j] : 0,
                            j + 1 < m ? maheshCaptured[i][j + 1] : 0
                    );
                }
            }
        }
        // suresh check up and left direction from the current
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (gameBoard[i][j] == 1) {
                    sureshCaptured[i][j] = 1 + Math.max(
                            i - 1 >= 0 ? sureshCaptured[i - 1][j] : 0,j - 1 >= 0 ? sureshCaptured[i][j - 1] : 0
                    );
                }
            }
        }
        for(int[] row:maheshCaptured){
            System.out.println(Arrays.toString(row));
        }
        for(int[] row:sureshCaptured){
            System.out.println(Arrays.toString(row));
        }
        return Math.min(maheshCaptured[0][0], sureshCaptured[0][0]);
    }

    public static void main(String[] args) {
        int[][] gameBoard = {
                {0, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sureshCellsCaptured = maxCellsCaptured(gameBoard);
        System.out.println("Suresh captures " + sureshCellsCaptured + " cells.");
    }

}
