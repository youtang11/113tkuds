package midterm;

import java.util.*;
public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] stops = sc.nextLine().split(" ");
        String[] se = sc.nextLine().split(" ");
        int startIdx = -1, endIdx = -1;
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(se[0])) startIdx = i;
            if (stops[i].equals(se[1])) endIdx = i;
        }
        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(startIdx - endIdx) + 1);
        }
        sc.close();
    }
}
/*
 * Time Complexity: O(n)
 * 說明：走訪停靠站陣列一次找起訖站索引，最大長度為 12，因此為 O(n)
 */