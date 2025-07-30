import java.util.*;

public class F05_LCMRecursive {
    static int gcd(int a, int b) {
        if (a == b) return a;
        return a > b ? gcd(a - b, b) : gcd(a, b - a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int g = gcd(a, b);
        System.out.println("LCM: " + (a * b / g));
        sc.close();
    }
}

/*
 * Time Complexity: O(max(a,b))
 * 說明：輾轉相減法每次至少減 1，最壞 O(max(a,b))。
 */
