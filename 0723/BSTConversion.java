public class BSTConversion {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode prev = null;
    static TreeNode head = null;

    // 1. BST 轉雙向排序鏈表
    public static void bstToDoublyList(TreeNode root) {
        if (root == null) return;
        bstToDoublyList(root.left);
        if (prev == null) head = root;
        else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        bstToDoublyList(root.right);
    }

    // 2. 排序陣列轉平衡 BST
    public static TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, l, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, r);
        return node;
    }

    // 3. BST每個節點改為大於等於該節點值之和
    public static int transformBST(TreeNode root, int sum) {
        if (root == null) return sum;
        sum = transformBST(root.right, sum);
        root.val += sum;
        return transformBST(root.left, root.val);
    }

    public static void main(String[] args) {
        // 範例: 建平衡 BST
        int[] arr = {1,2,3,4,5};
        TreeNode root = sortedArrayToBST(arr, 0, arr.length -1);
        transformBST(root, 0);
        bstToDoublyList(root);

        // 印出雙向鏈表
        TreeNode cur = head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();
    }
}
