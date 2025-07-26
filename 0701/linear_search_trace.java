/*Q2：線性搜尋比對追蹤
檔名：linear_search_trace.java
題目說明：
請撰寫一段 Java 程式，使用線性搜尋（Sequential Search）從一個整數陣列
中找尋目標數字，並印出每一次比對的過程。最後印出是否找到該數字。
範例輸出：
請輸入要搜尋的數字：7
比對中：7 vs 1
比對中：7 vs 3
比對中：7 vs 5
比對中：7 vs 7
結果：找到
額外要求：
• 陣列內容可寫死，例如 int[] s = {1, 3, 5, 7, 9};
• 使用 Scanner 讓使用者輸入搜尋值。*/
import java.util.Scanner;

public class linear_search_trace {
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9};
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入要搜尋的數字：");
        int target = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < s.length; i++) {
            System.out.println("比對中：" + target + " vs " + s[i]);
            if (s[i] == target) {
                found = true;
                break;
            }
        }

        System.out.println("結果：" + (found ? "找到" : "未找到"));
        sc.close();
    }
}
