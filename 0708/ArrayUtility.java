import java.util.Arrays;
public class ArrayUtility {
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
    public static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }
    public static int findSecondLargest(int[] array) {
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) { second = max; max = num; }
            else if (num > second && num != max) second = num;
        }
        return second;
    }
    public static void main(String[] args) {
        int[] data = {3, 7, 1, 9, 4, 6, 8, 2, 5};
        System.out.print("原始陣列："); printArray(data);
        reverseArray(data);
        System.out.print("反轉後："); printArray(data);
        int[] copied = copyArray(data);
        System.out.print("複製陣列："); printArray(copied);
        System.out.println("第二大數值：" + findSecondLargest(data));
    }
}