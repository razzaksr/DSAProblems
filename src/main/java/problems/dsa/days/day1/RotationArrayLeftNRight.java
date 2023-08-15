package problems.dsa.days.day1;

import java.util.Arrays;

public class RotationArrayLeftNRight {
    public static void rotateArrayAntiClock(String[] arr, int k) {
        int n = arr.length;
        String[] rotatedArr = new String[n];
        for (int i = 0; i < n; i++) {
            rotatedArr[(i - k+ n) % n] = arr[i];
            System.out.println((i - k+ n) % n);
        }
        // Copy the rotated elements back to the original array
        for (int i = 0; i < n; i++) {
            System.out.print(rotatedArr[i]+" ");
        }
        System.out.println();
    }
    public static void rotateArrayClock(String[] arr, int k) {
        int n = arr.length;
        String[] rotatedArr = new String[n];
        for (int i = 0; i < n; i++) {
            rotatedArr[(i + k) % n] = arr[i];
            System.out.println((i+k)%n);
        }
        for (int i = 0; i < n; i++) {System.out.print(rotatedArr[i]+" ");}
        System.out.println();
    }
    public static void main(String[] args) {
        String[] frameworks={"Node", "Django", "Vue", "Express", "Spring", "Flask", "Angular", "React", "Hibernate"};
        System.out.println(Arrays.toString(frameworks));
        rotateArrayClock(frameworks,2);
        rotateArrayAntiClock(frameworks,2);
    }

}
