package problems.dsa.days.day2;

public class DoFindSmallestMissingInSortedArray {
    public static int findSmallestMissing(int[] nums, int left, int right)
    {
        // base condition
        if (left > right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        // if the mid-index matches with its value, then the mismatch
        // lies on the right half
        if (nums[mid] == mid) {
            return findSmallestMissing(nums, mid + 1, right);
        }
        else {
            // mismatch lies on the left half
            return findSmallestMissing(nums, left, mid - 1);
        }
    }

    public static void main(String[] args)
    {
//        int[] nums = { 0, 1, 2, 3, 4, 5, 6 };
//        int[] nums = { 1, 2, 3, 4, 6, 9, 11, 15 };
        int[] nums = { 0, 1, 2, 6, 9, 11, 15 };

        int left = 0, right = nums.length - 1;
        System.out.println("The smallest missing element is "
                + findSmallestMissing(nums, left, right));
    }
}
