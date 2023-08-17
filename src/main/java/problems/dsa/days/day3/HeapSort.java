package problems.dsa.days.day3;

/*
Heap sort:
 0   1   2   3     4   5
3.4 9.2 1.12 12.09 4.5 7.2
              3.4           >> max | parent
         9.2       1.12
     12.09 4.5   7.2
 0
3.4 12.09 1.12 9.2 4.5 7.2
              3.4           >> max | parent
        12.09       1.12
     9.2   4.5   7.2
  0
12.09 3.4 1.12 9.2 4.5 7.2
             12.09           >> max | parent
        3.4       1.12
     9.2   4.5   7.2

7.2 3.4 1.12 9.2 4.5 12.09
             7.2           >> max | parent
        3.4       1.12
     9.2   4.5

7.2 9.2 1.12 3.4 4.5 12.09
             7.2           >> max | parent
        9.2       1.12
     3.4   4.5

9.2 7.2 1.12 3.4 4.5 12.09
             9.2           >> max | parent
        7.2       1.12
     3.4   4.5

4.5 7.2 1.12 3.4 9.2 12.09
             4.5           >> max | parent
        7.2       1.12
     3.4

7.2 4.5 1.12 3.4 9.2 12.09
             7.2           >> max | parent
        4.5       1.12
     3.4

3.4 4.5 1.12 7.2 9.2 12.09
             3.4           >> max | parent
        4.5       1.12

4.5 3.4 1.12 7.2 9.2 12.09
             4.5           >> max | parent
        3.4       1.12

1.12 3.4 4.5 7.2 9.2 12.09
             1.12          >> max | parent
        3.4

3.4 1.12 4.5 7.2 9.2 12.09
             3.4          >> max | parent
        1.12

1.12 3.4 4.5 7.2 9.2 12.09
             1.12          >> max | parent

 */

public class HeapSort {

    public static void heapify(double[] arr,int length, int parent){
        int maximum=parent;

        int left=parent*2+1;
        int right=parent*2+2;

        if(left<length&&arr[left]>arr[maximum]){
            maximum=left;
        }
        if(right<length&&arr[right]>arr[maximum]){
            maximum=right;
        }

        if(maximum!=parent){
            double third=arr[maximum];
            arr[maximum]=arr[parent];
            arr[parent]=third;
//            arr[maximum]*=arr[parent];
//            arr[parent]=arr[maximum]/arr[parent];
//            arr[maximum]/=arr[parent];
            heapify(arr,length,maximum);
        }
    }

    public static void sortHeap(double[] arr){
        for(int index=arr.length/2-1;index>=0;index--){
            heapify(arr, arr.length, index);
        }
        for(int position=arr.length-1; position>=0;position-- ){
            double third=arr[0];
            arr[0]=arr[position];
            arr[position]=third;
//            arr[0]*=arr[position];
//            arr[position]=arr[0]/arr[position];
//            arr[0]/=arr[position];
            heapify(arr,position,0);
        }
    }

    public static void show(double[] arr, int index){
        if(index<arr.length) {
            System.out.print(arr[index] + " ");
            index++;
            show(arr, index);
        }
    }

    public static void main(String[] args) {
        double[] myData={3.4,9.2,1.12,12.09,4.5,7.2};
        show(myData,0);
        System.out.println();
        sortHeap(myData);
        show(myData,0);
    }
}
