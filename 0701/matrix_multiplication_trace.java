/*Q3：矩陣乘法逐步顯示
檔名：matrix_multiplication_trace.java
題目說明：
請撰寫一個 Java 程式，實作兩個 2x2 矩陣相乘，並在每個位置的計算時印出
完整的乘法與加總過程。最後印出結果矩陣。
範例輸出：
計算位置 c[0][0]：1*5 + 2*7 = 5 + 14 = 19
計算位置 c[0][1]：1*6 + 2*8 = 6 + 16 = 22
...
結果矩陣：
19 22
43 50
額外要求：
• 矩陣內容寫死，如：
int[][] a = {{1, 2}, {3, 4}};
int[][] b = {{5, 6}, {7, 8}};
• 使用三層迴圈（i, j, k）實作。
• 說明此算法的時間複雜度為 O(n³)。
Q4*/
public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] c = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("計算位置 c[" + i + "][" + j + "]：");
                int sum = 0;
                for (int k = 0; k < 2; k++) {
                    int product = a[i][k] * b[k][j];
                    sum += product;
                    System.out.print(a[i][k] + "*" + b[k][j]);
                    if (k < 1) System.out.print(" + ");
                }
                System.out.println(" = " + sum);
                c[i][j] = sum;
            }
        }

        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
