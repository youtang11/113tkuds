import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble(); // 讀入浮點數
        System.out.printf("%.2f\n", num); // 保留兩位小數輸出
        sc.close();     
    }
}
