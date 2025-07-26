public class ArrayStatistics {
    public static void main(String[] args) {
        int[] numbers = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};
        int sum = 0, max = numbers[0], min = numbers[0];
        int maxIdx = 0, minIdx = 0, aboveAvgCount = 0;
        int evenCount = 0, oddCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (numbers[i] > max) { max = numbers[i]; maxIdx = i; }
            if (numbers[i] < min) { min = numbers[i]; minIdx = i; }
            if (numbers[i] % 2 == 0) evenCount++;
            else oddCount++;
        }
        double avg = (double) sum / numbers.length;
        for (int n : numbers) if (n > avg) aboveAvgCount++;
        System.out.printf("總和：%d\n平均值：%.2f\n", sum, avg);
        System.out.printf("最大值：%d（索引 %d）\n", max, maxIdx);
        System.out.printf("最小值：%d（索引 %d）\n", min, minIdx);
        System.out.printf("大於平均的數字數量：%d\n", aboveAvgCount);
        System.out.printf("偶數數量：%d，奇數數量：%d\n", evenCount, oddCount);
    }
}