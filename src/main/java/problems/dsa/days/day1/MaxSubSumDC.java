package problems.dsa.days.day1;

public class MaxSubSumDC {
    public static void findMaxSumSubArray(int[] arr){
        int maxSum=Integer.MIN_VALUE, subSum=0;
        for(int current=0;current<arr.length;current++){
            subSum=0;
            for(int sub=current;sub<arr.length;sub++){
                subSum+=arr[sub];
                //System.out.println(arr[sub]+" "+subSum);
                if(subSum>maxSum){
                    maxSum=subSum;
                }
            }
        }
        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {45,91,10,67,21,6,11};
        findMaxSumSubArray(arr);
        int[] nums = { 2, -4, 1, 9, -6, 7, -3 };
        findMaxSumSubArray(nums);
    }

}
