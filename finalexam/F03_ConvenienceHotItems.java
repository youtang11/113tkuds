import java.util.*;

class Item {
    String name;
    int qty;
    Item(String n, int q) { name = n; qty = q; }
}

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Item[] arr = new Item[n];
        for (int i = 0; i < n; i++) arr[i] = new Item(sc.next(), sc.nextInt());

        // 插入排序
        for (int i = 1; i < n; i++) {
            Item key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].qty < key.qty) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        for (int i = 0; i < Math.min(10, n); i++)
            System.out.println(arr[i].name + " " + arr[i].qty);
        sc.close();
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：插入排序在最壞情況下需要 O(n²) 次比較與移動。
 */
