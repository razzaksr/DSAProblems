package problems.dsa.days.day1;

public class ClimbStairsDC {
    public static int climbStairsRecursion(int n) {
        if (n <= 0) {return 0;
        } else if (n == 1) {return 1;
        } else if (n == 2) {
            return 2;
        } else {
            System.out.println(n);
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
    public static int climbStairs(int n) {
        if (n <= 0) {return 0;}
        else if (n == 1) {return 1;}
        else if (n == 2) {return 2;}
        int[] dp = new int[n + 1];
        dp[1] = 1;dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            System.out.println(dp[i]);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5; // Number of stairs
        int ways = climbStairs(n);
        System.out.println("Number of ways: " + ways);

    }

}
