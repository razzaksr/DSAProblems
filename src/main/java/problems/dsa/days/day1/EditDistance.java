package problems.dsa.days.day1;

import java.util.Arrays;

/*
Let's break down the code step by step:

Importing and Class Declaration:

We start with the declaration of the class EditDistance.
minDistance Function:

This function calculates the minimum number of operations required to convert word1 to word2.
m and n represent the lengths of word1 and word2, respectively.
A 2D array dp of size (m+1) x (n+1) is created to store the minimum edit distances.
Initialize First Row and Column:

The first row of the dp array represents the case when word1 is empty. So, we initialize it with the values 0 to n (insertion operations).
The first column of the dp array represents the case when word2 is empty. So, we initialize it with the values 0 to m (deletion operations).
Fill in the DP Array:

We iterate over each character of word1 (indexed from 1 to m) and each character of word2 (indexed from 1 to n).
For each character pair (i, j), we compare word1.charAt(i - 1) with word2.charAt(j - 1):
If the characters are the same, we inherit the minimum edit distance from the previous characters, i.e., dp[i][j] = dp[i - 1][j - 1].
If the characters are different, we take the minimum of three operations:
Replacement: 1 + dp[i - 1][j - 1]
Deletion: 1 + dp[i - 1][j]
Insertion: 1 + dp[i][j - 1]
This step fills the dp array bottom-up, using previous subproblem solutions.
main Function:

In the main function, we provide example inputs for word1 and word2.
We then call the minDistance function to calculate the minimum number of operations.
Finally, we print the result.
This algorithm utilizes dynamic programming to build a table of subproblem solutions, allowing it to efficiently find the minimum number of operations to transform one word into another.

step by step:
Certainly, let's break down the dynamic programming process step by step without the initialization of the first row and first column.

The dynamic programming table dp is used to store the minimum edit distances between prefixes of word1 and word2.

Given word1 = "horse" and word2 = "ros", we have:

markdown
Copy code
  -   r   o   s
-  ?   ?   ?   ?
h  ?   ?   ?   ?
o  ?   ?   ?   ?
r  ?   ?   ?   ?
s  ?   ?   ?   ?
e  ?   ?   ?   ?
Each cell (i, j) in the table represents the minimum number of operations required to transform the prefix of word1 up to length i into the prefix of word2 up to length j.

The values in the cells need to be filled using dynamic programming to calculate the minimum number of operations.

Here's how the table is filled:

Initialize the first row and first column (without insertion and deletion operations) as i and j respectively:
markdown
Copy code
  -   r   o   s
-  0   1   2   3
h  1
o  2
r  3
s  4
e  5
Fill in the rest of the cells using dynamic programming:
For each cell (i, j), consider the characters at word1.charAt(i - 1) and word2.charAt(j - 1).
If they are equal, the minimum edit distance is the same as the previous diagonal cell (i - 1, j - 1).
If they are not equal, the minimum edit distance is the minimum of three adjacent cells (i - 1, j - 1), (i - 1, j), and (i, j - 1) plus one.
After filling in the table, you'll end up with the following:

markdown
Copy code
  -   r   o   s
-  0   1   2   3
h  1   1   2   3
o  2   2   1   2
r  3   2   2   2
s  4   3   3   2
e  5   4   4   3
The value in the bottom-right cell (m, n) (where m is the length of word1 and n is the length of word2) represents the minimum number of operations required to convert the entire word1 to word2, which is 2 in this case.

So, without the initializations of the first row and first column, the dynamic programming table is constructed using the principles of the edit distance algorithm. However, these initializations are crucial to ensure that the algorithm properly handles cases where one of the words is empty or has a prefix of length 0.


 */

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Create a 2D array to store the minimum edit distances
        int[][] dp = new int[m+1][n+1];

        // Initialize the first row and first column
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int[] row:dp) {
            System.out.println(Arrays.toString(row));
        }
        // Fill in the rest of the array using dynamic programming
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
                System.out.println(dp[i][j]+" @ "+i+" and "+j);
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "madam";
        String word2 = "mam";
        int result = minDistance(word1, word2);
        System.out.println("Minimum number of operations: " + result);
    }
}

