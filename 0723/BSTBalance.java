public class BSTBalance {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 計算高度
    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // 判斷是否平衡
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh - rh) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 計算平衡因子
    public static int balanceFactor(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // 找最不平衡節點（第一次出現的）
    public static TreeNode mostUnbalanced(TreeNode root) {
        if (root == null) return null;
        if (Math.abs(balanceFactor(root)) > 1) return root;
        TreeNode left = mostUnbalanced(root.left);
        if (left != null) return left;
        return mostUnbalanced(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(30);

        System.out.println("是否平衡: " + isBalanced(root));
        System.out.println("根節點平衡因子: " + balanceFactor(root));
        TreeNode unbalanced = mostUnbalanced(root);
        System.out.println("最不平衡節點值: " + (unbalanced != null ? unbalanced.val : "無"));
    }
}
