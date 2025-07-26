import java.util.Scanner;

public class Main20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                continue; // 偶數跳過
            }
            sum += i;
        }

        System.out.println(sum);
    }
}
