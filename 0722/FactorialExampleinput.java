import java.util.Scanner;

public class FactorialExampleinput{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入一個正整數：");

        if (!sc.hasNextInt()) {
            System.out.println("輸入錯誤，請輸入正整數！");
            return;
        }

        int n = sc.nextInt();
        
        if (n < 0) {
            System.out.println("輸入錯誤，請輸入正整數！");
            return;
        } 

        StringBuilder expression = new StringBuilder();
        int result = 1;

        for (int i = n; i >= 1; i--) {
            result *= i;
            expression.append(i);
            if (i > 1) {
                expression.append("*");
            }
        }

        // 特殊處理 0! = 1
        if (n == 0) {
            expression.append("1");
        }
        
        System.out.println(n + "! = " + expression + " = " + result);
        sc.close();
        }
}
