import java.util.Scanner;

public class Main14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int[][] matrix = new int[n][n];

        // 方向向量：右、下、左、上
        int[] dx = {0, 1, 0, -1}; // 控制行（row）
        int[] dy = {1, 0, -1, 0}; // 控制列（col）
        int dir = 0; // 初始方向：右

        int x = 0, y = 0; // 起點位置
        for (int num = 1; num <= n * n; num++) {
            matrix[x][y] = num;

            // 計算下一格
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 如果下一格超界或已填過，就轉向
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || matrix[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        // 輸出矩陣
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                if (j != n - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
