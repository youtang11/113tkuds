import java.util.*;

public class F08_ClimbStairsMemo {
    static long[] memo = new long[50];
    static long f(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (memo[n] != 0) return memo[n];
        return memo[n] = f(n - 1) + f(n - 2) + f(n - 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Ways: " + f(n));
        sc.close();
    }
}
