package problems.dsa.days.day1;

import java.util.Arrays;

public class AirportRisk {
    public static void sortItemsByRisk(int[] arr) {
        int n = arr.length;
        int[] count = new int[3]; // Count of items with risk 0, 1, and 2
        // Count the frequency of each risk level
        for (int i = 0; i < n; i++) {
            count[arr[i]]++; System.out.println(count[arr[i]]);
        }
        System.out.println(Arrays.toString(count));
        int index = 0;
        // Reconstruct the sorted array based on risk levels
        for (int i = 0; i < 3; i++) {
            while (count[i] > 0) {
                arr[index++] = i;count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] items = {1, 0, 2,2,1, 1,2,2,1, 0, 2, 1, 0, 2};
        sortItemsByRisk(items);
        System.out.println(Arrays.toString(items));
    }

}
