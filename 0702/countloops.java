public class countloops {
    public static void main(String[] args) {
        int n = 5;
        int sum = 0;
        int count = 0; //紀錄加法執行次數

        for (int i = 1; i <= n; i++) {
            System.out.println("第 "+i+" 次迴圈，sum = "+sum+"+"+i);
            sum += 1;
            count++; //每次加法都記錄一次
        }

        System.out.println("總和為: "+sum);
        System.out.println("加法執行了 "+count+" 次");
    }
}