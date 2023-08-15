package problems.dsa.days.day1;

/*
Input:  A[] = [1, 9, 6, 4, 5]
Output: The inversion count is 5
There are 5 inversions in the array: (9, 6), (9, 4), (9, 5), (6, 4), (6, 5)

 */

public class InversionCountOfArray {
    public static int inversionCount(int[] arr){
        int inversions=0;
        for(int current=0;current<arr.length-1;current++){
            for(int adjucent=current+1;adjucent<arr.length;adjucent++){
                if(arr[current]>arr[adjucent]){inversions++;}
            }
        }
        return inversions;
    }
    public static void main(String[] args) {
        int[] arr = {45,91,10,67,21,6,11};
        System.out.println(inversionCount(arr));
    }

}
