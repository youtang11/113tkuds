public class IsSorted {
    public static boolean isSorted(int[] arr, int index) {
        if (index >= arr.length - 1) return true;
        if (arr[index] > arr[index + 1]) return false;
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 3, 8};
        System.out.println("arr1 isSorted? " + isSorted(arr1, 0)); // true
        System.out.println("arr2 isSorted? " + isSorted(arr2, 0)); // false
    }
}
