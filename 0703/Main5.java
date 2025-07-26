import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int F = (C * 9/5) + 32;
        System.out.println(F);
        sc.close();
    }
}