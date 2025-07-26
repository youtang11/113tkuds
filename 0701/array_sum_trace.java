/*Q1：陣列加總過程追蹤
檔名：array_sum_trace.java
題目說明：
請設計一個 Java 程式，對一個整數陣列中的元素進行逐一加總，並在每一次
加總時顯示加總過程，最後印出總和。
範例輸出：
加總過程：total = 0 + 1 = 1
加總過程：total = 1 + 3 = 4
加總過程：total = 4 + 5 = 9
總和為：9
額外要求：
• 陣列可使用固定值，如：int[] arr = {1, 3, 5};
• 說明此演算法的時間複雜度。*/
public class array_sum_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("加總過程：total = " + total + " + " + arr[i] + " = " + (total + arr[i]));
            total += arr[i];
        }
        System.out.println("總和為：" + total);
    }
}