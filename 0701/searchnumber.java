import java.util.Scanner;

public class searchnumber {
    public static void main(String[] args) {
        int[]s = {1,3,5,7,9,11,13}; //以排序的數列
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入要查找的數字:");
        int x = sc.nextInt();
        boolean found = false;

        for (int num : s) {
            if (num == x) {
                found = true;
                break;
            }
        }
    }
}