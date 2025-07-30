import java.util.*;

class Node {
    int val; Node left, right;
    Node(int v) { val = v; }
}

public class F09_BinaryTreeLeftView {
    static Node build(Integer[] arr) {
        if (arr.length == 0) return null;
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node cur = q.poll();
            if (i < arr.length && arr[i] != null) cur.left = new Node(arr[i]);
            if (cur.left != null) q.add(cur.left);
            i++;
            if (i < arr.length && arr[i] != null) cur.right = new Node(arr[i]);
            if (cur.right != null) q.add(cur.right);
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        Integer[] arr = new Integer[tokens.length];
        for (int i = 0; i < tokens.length; i++) arr[i] = tokens[i].equals("-1") ? null : Integer.parseInt(tokens[i]);
        Node root = build(arr);

        Queue<Node> q = new LinkedList<>();
        if (root != null) q.add(root);
        System.out.print("LeftView:");
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (i == 0) System.out.print(" " + cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        System.out.println();
        sc.close();
    }
}