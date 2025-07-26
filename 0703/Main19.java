import java.util.Scanner;

public class Main19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        for (int num = 2; num <= N; num++) {
            boolean isPrime = true;

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;  // 發現非質數，跳出內層迴圈
                }
            }

            if (isPrime) {
                System.out.print(num + " ");
            }
        }
        System.out.println(); // 換行
    }
}
