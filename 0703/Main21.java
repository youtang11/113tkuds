import java.util.Scanner;

public class Main21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        sc.close();

        double area = 3.14 * r * r;

        System.out.printf("%.2f\n", area);
    }
}
