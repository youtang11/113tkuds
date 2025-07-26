package midterm;

import java.util.*;
public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), total = 0;
        int[] bills = new int[n];
        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();
            bills[i] = calc(kWh);
            total += bills[i];
        }
        for (int b : bills) System.out.println("Bill: $" + b);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + Math.round((double) total / n));
        sc.close();
    }
    static int calc(int kWh) {
        int[] limits = {120, 210, 170, 200, 300, Integer.MAX_VALUE};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};
        int cost = 0, remain = kWh;
        for (int i = 0; i < limits.length; i++) {
            int use = Math.min(remain, limits[i]);
            cost += use * rates[i];
            remain -= use;
            if (remain == 0) break;
        }
        return (int) Math.round(cost);
    }
}
/*
 * Time Complexity: O(n)
 * 說明：每筆資料呼叫 calc(kWh)，calc 中最多跑 6 次，整體為 O(n)
 */