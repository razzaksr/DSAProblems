package problems.dsa.days.day1;

public class EquilibriumIndex {
    public static int equilibriumIndex(int[] arr){
        int cumulateSum=0;
        int westSum=0;
        for(int each:arr){
            cumulateSum+=each;
        }
        for(int index=0;index<arr.length;index++){
            cumulateSum-=arr[index];
            if(westSum==cumulateSum)
                return index;
            westSum+=arr[index];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(equilibriumIndex(arr));
    }

}
