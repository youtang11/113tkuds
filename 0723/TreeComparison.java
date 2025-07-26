public class TreeComparison {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 1. 判斷兩棵樹是否完全相同
    public static boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }

    // 2. 判斷是否為子樹
    public static boolean isSubtree(TreeNode root, TreeNode sub) {
        if (root == null) return false;
        if (isSame(root, sub)) return true;
        return isSubtree(root.left, sub) || isSubtree(root.right, sub);
    }

    // 3. 找最大公共子樹（簡單版：以子樹完全相同為標準）
    // 實務較複雜，這裡只示範是否有公共子樹
    public static TreeNode largestCommonSubtree(TreeNode a, TreeNode b) {
        if (a == null || b == null) return null;
        if (isSame(a, b)) return a;
        TreeNode left = largestCommonSubtree(a.left, b);
        TreeNode right = largestCommonSubtree(a.right, b);
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);

        TreeNode B = new TreeNode(2);

        System.out.println("是否完全相同: " + isSame(A, B));
        System.out.println("B是否為A子樹: " + isSubtree(A, B));
    }
}
