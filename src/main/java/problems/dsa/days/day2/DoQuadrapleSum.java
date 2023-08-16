package problems.dsa.days.day2;

import java.util.Arrays;

public class DoQuadrapleSum {

    public static boolean hasQuadruplet(int[] nums, int n, int target, int count)
    {
        System.out.println(n+" "+target+" "+count);
        // if the desired sum is reached with 4 elements, return true
        if (target == 0 && count == 4) {
            return true;
        }

        // return false if the sum is not possible with the current configuration
        if (count > 4 || n == 0) {
            return false;
        }

        // Recur with
        // 1. Including the current element
        // 2. Excluding the current element

        return hasQuadruplet(nums, n - 1, target - nums[n - 1], count + 1) ||
                hasQuadruplet(nums, n - 1, target, count);
    }

    // Function to print all quadruplet present in an array with a given sum
    public static void quadTuplePrint(int[] A, int target)
    {
        // sort the array in ascending order
        Arrays.sort(A);

        // check if quadruplet is formed by `A[i]`, `A[j]`, and a pair from
        // subarray `A[j+1…n)`
        for (int i = 0; i <= A.length - 4; i++)
        {
            for (int j = i + 1; j <= A.length - 3; j++)
            {
                // `k` stores remaining sum
                int k = target - (A[i] + A[j]);

                // check for sum `k` in subarray `A[j+1…n)`
                int low = j + 1, high = A.length - 1;

                while (low < high)
                {
                    if (A[low] + A[high] < k) {
                        low++;
                    }
                    else if (A[low] + A[high] > k) {
                        high--;
                    }
                    // quadruplet with a given sum found
                    else {
                        System.out.println("(" + A[i] + " " + A[j] + " " +
                                A[low] + " " + A[high] + ")");
                        low++;
                        high--;
                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[] nums = { 2, 7, 4, 0, 9, 5, 1, 3 };
        int target = 20;

        //quadTuplePrint(A, target);
        if (hasQuadruplet(nums, nums.length, target, 0)) {
            System.out.println("Quadruplet exists");
        }
        else {
            System.out.println("Quadruplet Doesn't Exist");
        }
    }
}
