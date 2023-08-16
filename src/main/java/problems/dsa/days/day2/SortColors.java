package problems.dsa.days.day2;

public class SortColors {
    public static void sortColors(int[] nums) {
        int low = 0;  // Pointer for 0s
        int high = nums.length - 1;  // Pointer for 2s
        int curr = 0;  // Current pointer

        while (curr <= high) {
            if (nums[curr] == 0) {
                // Swap with the low pointer
                int temp = nums[curr];
                nums[curr] = nums[low];
                nums[low] = temp;
                curr++;
                low++;
            } else if (nums[curr] == 2) {
                // Swap with the high pointer
                int temp = nums[curr];
                nums[curr] = nums[high];
                nums[high] = temp;
                high--;
            } else {
                curr++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 0 0 1 1 2 2
    }
}

