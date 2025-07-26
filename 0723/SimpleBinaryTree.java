public class SimpleBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 倒過來印出二元樹的圖形（右在上、左在下）
    public static void printTree(TreeNode node, int depth) {
        if (node == null) return;

        printTree(node.right, depth + 1); // 先印右子樹
        System.out.println(" ".repeat(depth * 4) + node.data); // 印當前節點（4個空白一層）
        printTree(node.left, depth + 1);  // 再印左子樹
    }

    public static void main(String[] args) {
        // 建立一個簡單的二元樹
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 印出樹的基本資訊
        System.out.println("樹的結構:");
        System.out.println("根節點: " + root.data);
        System.out.println("左子樹: " + root.left.data);
        System.out.println("右子樹: " + root.right.data);
        System.out.println("左子樹的左子樹: " + root.left.left.data);
        System.out.println("左子樹的右子樹: " + root.left.right.data);

        // 印出圖形結構
        System.out.println("\n圖形結構如下:");
        printTree(root, 0);
    }
}
