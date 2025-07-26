/*Q4：找出陣列中出現次數最多的數字
檔名：array_mode_count.java
題目說明：
請撰寫一段 Java 程式，找出一個整數陣列中**出現次數最多的元素（眾數）
**與其出現次數，並印出比對過程。
範例輸出：
比對中：3 出現次數 = 2
比對中：7 出現次數 = 1
比對中：3 出現次數 = 2
比對中：1 出現次數 = 3
眾數為：1，出現 3 次
額外要求：
• 陣列內容自訂即可，例如：{3, 7, 3, 1, 1, 1}
• 請使用巢狀迴圈實作（不可使用 Map）
• 說明此作法的時間複雜度為 O(n²)，是否可改善？
 */

public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3, 7, 3, 1, 1, 1};
        int mode = arr[0];
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            System.out.println("比對中：" + arr[i] + " 出現次數 = " + count);

            if (count > maxCount) {
                maxCount = count;
                mode = arr[i];
            }
        }

        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}