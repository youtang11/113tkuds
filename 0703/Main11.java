import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 行數
        int m = sc.nextInt(); // 列數

        int[][] arr = new int[n][m];
        int[] colSum = new int[m]; // 用來累加每一列的總和

        // 讀入資料並計算每一列的總和
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                colSum[j] += arr[i][j]; // 對每一列加總
            }
        }

        sc.close();

        // 輸出列總和
        for (int j = 0; j < m; j++) {
            System.out.print(colSum[j]);
            if (j < m - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
