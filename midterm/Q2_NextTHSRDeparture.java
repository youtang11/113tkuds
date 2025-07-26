package midterm;

import java.util.*;
public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] minutes = new int[n];
        for (int i = 0; i < n; i++) {
            String[] hm = sc.nextLine().split(":");
            minutes[i] = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
        }
        String[] q = sc.nextLine().split(":");
        int query = Integer.parseInt(q[0]) * 60 + Integer.parseInt(q[1]);
        int idx = Arrays.binarySearch(minutes, query);
        if (idx < 0) idx = -idx - 1;
        else idx++;
        if (idx >= n) {
            System.out.println("No train");
        } else {
            System.out.printf("%02d:%02d\n", minutes[idx]/60, minutes[idx]%60);
        }
        sc.close();
    }
}
/*
 * Time Complexity: O(log n)
 * 說明：使用 Arrays.binarySearch 搜尋下一班車，時間複雜度為 O(log n)
 */