import java.util.Scanner;

public class Palindrome {

    // 遞迴檢查是否為回文
    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }

    // 反轉字串
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入一個字串：");
        String input = sc.nextLine();

        String reversed = reverseString(input);
        boolean isPalin = isPalindrome(input, 0, input.length() - 1);

        System.out.println("反轉後的字串為：" + reversed);
        System.out.println(input + " 是回文嗎？ " + isPalin);

        sc.close();
    }
}