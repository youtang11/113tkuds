import java.util.*;

class BST {
    int val; BST left, right;
    BST(int v) { val = v; }
}

public class F10_BSTRangeSum {
    static BST insert(BST root, int v) {
        if (root == null) return new BST(v);
        if (v < root.val) root.left = insert(root.left, v);
        else root.right = insert(root.right, v);
        return root;
    }

    static int rangeSum(BST root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSum(root.right, L, R);
        if (root.val > R) return rangeSum(root.left, L, R);
        return root.val + rangeSum(root.left, L, R) + rangeSum(root.right, L, R);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); BST root = null;
        for (int i = 0; i < n; i++) root = insert(root, sc.nextInt());
        int L = sc.nextInt(), R = sc.nextInt();
        System.out.println("Sum: " + rangeSum(root, L, R));
        sc.close();
    }
}