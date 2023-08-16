package problems.dsa.days.day2;

public class SumsOfDistance {
    public static int[] sumOfDistancesInArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && nums[i] == nums[j]) {
                    sum += Math.abs(i - j);
                }
            }
            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 1, 1, 2 };
        int[] result = sumOfDistancesInArray(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output: 5 0 3 4 0
    }
}
