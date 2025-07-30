import java.util.*;

public class F02_YouBikeNextFull {
    static int toMinutes(String t) {
        String[] parts = t.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    static String toTime(int m) {
        return String.format("%02d:%02d", m / 60, m % 60);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) times[i] = toMinutes(sc.next());

        int query = toMinutes(sc.next());
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (times[mid] > query) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }

        if (ans == -1) System.out.println("No bike");
        else System.out.println(toTime(times[ans]));
        sc.close();
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：二分搜尋找到第一個大於查詢時間的元素。
 */
