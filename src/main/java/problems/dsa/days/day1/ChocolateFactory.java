package problems.dsa.days.day1;

import java.util.Arrays;

public class ChocolateFactory {
    public static void moveEmptyPacketsToEnd(int[] arr) {
        int n = arr.length, nonEmptyIndex = 0;
        // Traverse the array and move non-empty packets to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[nonEmptyIndex] = arr[i];
                System.out.println(nonEmptyIndex+" "+Arrays.toString(arr));nonEmptyIndex++;
            }
        }
        // Fill the remaining slots with empty packets
        while (nonEmptyIndex < n) {
            arr[nonEmptyIndex] = 0;
            nonEmptyIndex++;
        }
    }

    public static void main(String[] args) {
        int[] chocolatePackets = {2, 0, 3, 0, 1, 0, 5};
        moveEmptyPacketsToEnd(chocolatePackets);
        System.out.println(Arrays.toString(chocolatePackets));
    }

}
