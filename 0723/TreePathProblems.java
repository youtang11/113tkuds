import java.util.*;

public class TreePathProblems {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 1. 找出從根到所有葉節點的路徑
    public static void allRootToLeafPaths(TreeNode root, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        } else {
            allRootToLeafPaths(root.left, path, res);
            allRootToLeafPaths(root.right, path, res);
        }
        path.remove(path.size() - 1);
    }

    // 2. 判斷是否存在和為目標值的根到葉路徑
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // 3. 找出和最大的根到葉路徑
    public static List<Integer> maxSumPath(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        maxSumPathHelper(root, new ArrayList<>(), res, Integer.MIN_VALUE);
        return res;
    }

    private static int maxSumPathHelper(TreeNode root, List<Integer> curPath, List<Integer> maxPath, int maxSum) {
        if (root == null) return maxSum;
        curPath.add(root.val);

        if (root.left == null && root.right == null) {
            int sum = curPath.stream().mapToInt(i -> i).sum();
            if (sum > maxSum) {
                maxPath.clear();
                maxPath.addAll(curPath);
                maxSum = sum;
            }
        } else {
            maxSum = maxSumPathHelper(root.left, curPath, maxPath, maxSum);
            maxSum = maxSumPathHelper(root.right, curPath, maxPath, maxSum);
        }
        curPath.remove(curPath.size() - 1);
        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        // 1
        List<List<Integer>> allPaths = new ArrayList<>();
        allRootToLeafPaths(root, new ArrayList<>(), allPaths);
        System.out.println("All root-to-leaf paths: " + allPaths);

        // 2
        System.out.println("Has path sum 22: " + hasPathSum(root, 22));

        // 3
        System.out.println("Max sum root-to-leaf path: " + maxSumPath(root));
    }
}
