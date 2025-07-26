public class BSTKthElement {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static int count = 0;
    static int result = -1;

    public static void findKth(TreeNode root, int k) {
        if (root == null) return;
        findKth(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        findKth(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);

        findKth(root, 3);
        System.out.println("第3小元素為: " + result); // 15
    }
}
