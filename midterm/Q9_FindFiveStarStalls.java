package midterm;

import java.util.*;
public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) score[i] = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) if (score[i] == 5) res.add(i);
        if (res.isEmpty()) System.out.println("None");
        else res.forEach(idx -> System.out.print(idx + " "));
        sc.close();
    }
}