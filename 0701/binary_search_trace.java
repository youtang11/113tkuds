/*Q5：有序陣列的二元搜尋比對過程
檔名：binary_search_trace.java
題目說明：
請撰寫一段 Java 程式，實作二元搜尋法（Binary Search），在一個升冪排序
的整數陣列中尋找使用者輸入的目標值，並印出每次比對的範圍與中位數。
範例輸出：
請輸入要搜尋的數字：11
搜尋範圍：left = 0, right = 6, mid = 3 → arr[mid] = 7
搜尋範圍：left = 4, right = 6, mid = 5 → arr[mid] = 11
結果：已找到！
額外要求：
• 陣列可設定為 {1, 3, 5, 7, 9, 11, 13}
• 必須逐步印出 left、right、mid 的變化過程。
• 與線性搜尋比較效率（時間複雜度 O(log n)） */

import java.util.Scanner;

public class binary_search_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入要搜尋的數字：");
        int target = sc.nextInt();

        int left = 0;
        int right = arr.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("搜尋範圍：left = " + left + ", right = " + right + ", mid = " + mid + " → arr[mid] = " + arr[mid]);

            if (arr[mid] == target) {
                found = true;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("結果：" + (found ? "已找到！" : "找不到"));
        sc.close();
    }
}
