import java.util.*;

public class q1arraysum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0, ops = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextInt();
            ops++;
        }
        System.out.println(sum);
        System.out.println(ops);
        sc.close();
    }
}
