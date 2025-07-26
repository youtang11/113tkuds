package midterm;

import java.util.*;
public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) arr[i] = sc.nextInt();
        for (int i = 0; i < 3; i++) {
            int t = arr[i];
            arr[i] = arr[6 - i];
            arr[6 - i] = t;
        }
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
        sc.close();
    }
}