package midterm;

import java.util.*;
public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) data[i] = sc.nextInt();
        int k = sc.nextInt();
        int[] prefix = new int[k];
        prefix[0] = data[0];
        for (int i = 1; i < k; i++) prefix[i] = prefix[i - 1] + data[i];
        System.out.print("PrefixSum:");
        for (int i = 0; i < k; i++) System.out.print(" " + prefix[i]);
        System.out.println();
        sc.close();
    }
}
/*
 * Time Complexity: O(n)
 * 說明：建表一次走訪 prefix 陣列，最多 144 次運算
 */