import java.util.*;

public class TreeReconstruction {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 前序 + 中序重建
    public static TreeNode buildPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) idxMap.put(inorder[i], i);
        return buildPreInHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length -1, idxMap);
    }

    private static TreeNode buildPreInHelper(int[] pre, int preStart, int preEnd,
                                             int[] in, int inStart, int inEnd,
                                             Map<Integer, Integer> idxMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int inRootIdx = idxMap.get(root.val);
        int leftTreeSize = inRootIdx - inStart;
        root.left = buildPreInHelper(pre, preStart + 1, preStart + leftTreeSize,
                                    in, inStart, inRootIdx - 1, idxMap);
        root.right = buildPreInHelper(pre, preStart + leftTreeSize + 1, preEnd,
                                     in, inRootIdx + 1, inEnd, idxMap);
        return root;
    }

    // 後序 + 中序重建
    public static TreeNode buildPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) idxMap.put(inorder[i], i);
        return buildPostInHelper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, idxMap);
    }

    private static TreeNode buildPostInHelper(int[] post, int postStart, int postEnd,
                                              int[] in, int inStart, int inEnd,
                                              Map<Integer, Integer> idxMap) {
        if (postStart > postEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(post[postEnd]);
        int inRootIdx = idxMap.get(root.val);
        int leftTreeSize = inRootIdx - inStart;
        root.left = buildPostInHelper(post, postStart, postStart + leftTreeSize - 1,
                                     in, inStart, inRootIdx -1, idxMap);
        root.right = buildPostInHelper(post, postStart + leftTreeSize, postEnd - 1,
                                      in, inRootIdx + 1, inEnd, idxMap);
        return root;
    }

    // 中序遍歷印出驗證
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode root1 = buildPreIn(preorder, inorder);
        System.out.print("Pre+In重建中序: ");
        printInOrder(root1);
        System.out.println();

        TreeNode root2 = buildPostIn(postorder, inorder);
        System.out.print("Post+In重建中序: ");
        printInOrder(root2);
        System.out.println();
    }
}
