import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        for (int i = 1; i <= n; i++) {
            // 用 StringBuilder 暫存每一行
            StringBuilder sb = new StringBuilder();

            // 遞增：1 到 i
            for (int j = 1; j <= i; j++) {
                sb.append(j).append(" ");
            }

            // 遞減：i-1 到 1
            for (int j = i - 1; j >= 1; j--) {
                sb.append(j);
                if (j != 1) sb.append(" ");
            }

            System.out.println(sb.toString().trim()); // ✅ 移除尾端空格
        }
    }
}
