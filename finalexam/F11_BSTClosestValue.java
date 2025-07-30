import java.util.*;

public class F11_BSTClosestValue {
    static BST insert(BST root, int v) {
        if (root == null) return new BST(v);
        if (v < root.val) root.left = insert(root.left, v);
        else root.right = insert(root.right, v);
        return root;
    }

    static int closest(BST root, int t) {
        int ans = root.val;
        while (root != null) {
            if (Math.abs(root.val - t) < Math.abs(ans - t) ||
               (Math.abs(root.val - t) == Math.abs(ans - t) && root.val < ans))
                ans = root.val;
            root = t < root.val ? root.left : root.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); BST root = null;
        for (int i = 0; i < n; i++) root = insert(root, sc.nextInt());
        int t = sc.nextInt();
        System.out.println("Closest: " + closest(root, t));
        sc.close();
    }
}