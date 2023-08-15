package problems.dsa.days.day1;

import java.util.Arrays;

public class PreAndSuffixSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // Print the prefix sum array
        for (int num : prefixSum) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] postFix=new int[n];
        postFix[n-1]=arr[n-1];
        for(int index=n-2;index>=0;index--){
            postFix[index]=postFix[index+1]+arr[index];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(postFix));

    }
}
