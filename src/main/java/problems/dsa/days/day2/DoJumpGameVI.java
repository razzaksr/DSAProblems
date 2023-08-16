package problems.dsa.days.day2;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoJumpGameVI {
    public static int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> maxDeque = new ArrayDeque<>();
        maxDeque.offer(0);

        for (int i = 1; i < n; i++) {
            while (!maxDeque.isEmpty() && maxDeque.peekFirst() < i - k) {
                maxDeque.pollFirst();
            }

            dp[i] = dp[maxDeque.peekFirst()] + nums[i];

            while (!maxDeque.isEmpty() && dp[i] >= dp[maxDeque.peekLast()]) {
                maxDeque.pollLast();
            }

            maxDeque.offerLast(i);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, -1, -2, 4, -7, 3};
        int k1 = 2;
        System.out.println(maxResult(nums1, k1));  // Output: 7

        int[] nums2 = {10, -5, -2, 4, 0, 3};
        int k2 = 3;
        System.out.println(maxResult(nums2, k2));  // Output: 17

        int[] nums3 = {1, -5, -20, 4, -1, 3, -6, -3};
        int k3 = 2;
        System.out.println(maxResult(nums3, k3));  // Output: 0
    }
}
