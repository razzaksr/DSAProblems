package problems.dsa.days.day1;

import java.util.Arrays;

public class OptimalSeatEfficiency {
    public static int findOptimalInefficiency(int N, int K, int[] salaries) {
        Arrays.sort(salaries);
        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            int arguments = 0;
            dp[i] = Integer.MAX_VALUE;

            for (int j = 1; j <= i; j++) {
                sum += salaries[j - 1];
                int difference = sum - j * salaries[j - 1];
                arguments += Math.max(0, difference);
                dp[i] = Math.min(dp[i], dp[j - 1] + K + arguments);
            }
        }

        return dp[N];
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        System.out.println(findOptimalInefficiency(arr.length,2,arr));

    }

}
