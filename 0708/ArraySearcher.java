public class ArraySearcher {
    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) if (array[i] == target) return i;
        return -1;
    }
    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int value : array) if (value == target) count++;
        return count;
    }
    public static void main(String[] args) {
        int[] data = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};
        System.out.println("67 的索引位置：" + findElement(data, 67));
        System.out.println("100 的索引位置：" + findElement(data, 100));
        System.out.println("67 出現次數：" + countOccurrences(data, 67));
    }
}