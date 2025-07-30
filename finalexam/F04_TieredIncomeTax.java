import java.util.*;

public class F04_TieredIncomeTax {
    static int calcTax(int income) {
        int[] limit = {540000, 1210000, 2420000, 4530000};
        double[] rate = {0.05, 0.12, 0.20, 0.30, 0.40};
        int[] base = {0, 37800, 134600, 376600, 829600};
        int idx = 0;
        while (idx < limit.length && income > limit[idx]) idx++;
        return (int)Math.round(base[idx] + rate[idx]*(income - (idx==0?0:limit[idx-1])));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int t = calcTax(sc.nextInt());
            sum += t;
            System.out.println("Tax: $" + t);
        }
        System.out.println("Average: $" + (sum / n));
        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每個收入計算稅額只需一次固定迴圈。
 */
