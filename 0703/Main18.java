import java.util.Scanner;

public class Main18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Y = sc.nextInt();
        sc.close();

        if ((Y % 400 == 0) || (Y % 4 == 0 && Y % 100 != 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
