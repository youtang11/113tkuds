import java.util.*;

public class TreeDistance {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 找最低公共祖先 (LCA)
    public static TreeNode lowestCommonAncestor(TreeNode root, int a, int b) {
        if (root == null) return null;
        if (root.val == a || root.val == b) return root;

        TreeNode left = lowestCommonAncestor(root.left, a, b);
        TreeNode right = lowestCommonAncestor(root.right, a, b);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // 從 root 開始找節點 val 的距離 (深度)
    public static int depth(TreeNode root, int val, int dist) {
        if (root == null) return -1;
        if (root.val == val) return dist;

        int left = depth(root.left, val, dist + 1);
        if (left != -1) return left;

        return depth(root.right, val, dist + 1);
    }

    // 計算任意兩節點距離
    public static int distance(TreeNode root, int a, int b) {
        TreeNode lca = lowestCommonAncestor(root, a, b);
        if (lca == null) return -1; // 找不到其中一個節點
        int distA = depth(lca, a, 0);
        int distB = depth(lca, b, 0);
        return distA + distB;
    }

    // 計算樹的直徑(任意兩節點最大距離)
    static int diameter = 0;

    private static int heightForDiameter(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = heightForDiameter(root.left);
        int rightHeight = heightForDiameter(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int treeDiameter(TreeNode root) {
        diameter = 0;
        heightForDiameter(root);
        return diameter;
    }

    // 找距離根節點指定距離的所有節點
    public static void nodesAtDistance(TreeNode root, int dist, List<Integer> res) {
        if (root == null) return;

        if (dist == 0) {
            res.add(root.val);
            return;
        }

        nodesAtDistance(root.left, dist - 1, res);
        nodesAtDistance(root.right, dist - 1, res);
    }

    public static void main(String[] args) {
        // 建立一棵簡單樹
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("4 到 5 的距離: " + distance(root, 4, 5));  // 預期 2
        System.out.println("2 到 3 的距離: " + distance(root, 2, 3));  // 預期 3
        System.out.println("樹的直徑: " + treeDiameter(root));          // 預期 3 (4->2->1->3)

        List<Integer> nodes = new ArrayList<>();
        nodesAtDistance(root, 2, nodes);
        System.out.println("距離根節點 2 的節點: " + nodes);  // 預期 [4,5]
    }
}
