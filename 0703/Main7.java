import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char ch = sc.next().charAt(0); // 讀入一個字符
        int ASCII = (int) ch; // 顯式轉型為 int 得到 ASCII 值

        System.out.println(ASCII);
        sc.close();
    }
}
