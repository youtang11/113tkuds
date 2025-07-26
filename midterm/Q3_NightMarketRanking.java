package midterm;

import java.util.*;
public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextDouble();
        for (int i = 0; i < Math.min(5, n); i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) maxIdx = j;
            }
            double temp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = temp;
            System.out.printf("%.1f\n", scores[i]);
        }
        sc.close();
    }
}
/*
 * Time Complexity: O(n^2)
 * 說明：選擇排序內外兩層迴圈，最差情況為 O(n^2)
 */