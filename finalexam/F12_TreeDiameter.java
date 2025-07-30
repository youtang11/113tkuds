import java.util.*;

public class F12_TreeDiameter {
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

    static int diameter = 0;
    static int height(Node root) {
        if (root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        diameter = Math.max(diameter, l + r);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        Integer[] arr = new Integer[tokens.length];
        for (int i = 0; i < tokens.length; i++) arr[i] = tokens[i].equals("-1") ? null : Integer.parseInt(tokens[i]);
        Node root = build(arr);
        height(root);
        System.out.println("Diameter: " + diameter);
        sc.close();
    }
}