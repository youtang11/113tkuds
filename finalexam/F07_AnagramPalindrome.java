import java.util.*;

public class F07_AnagramPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) if (Character.isLetter(c)) cnt[c - 'a']++;
        int odd = 0;
        for (int c : cnt) if (c % 2 == 1) odd++;
        System.out.println(odd > 1 ? "Impossible" : "Possible");
        sc.close();
    }
}
