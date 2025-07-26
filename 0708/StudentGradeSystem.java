public class StudentGradeSystem {
    public static char getGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else return 'D';
    }
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        int max = scores[0], min = scores[0], maxIdx = 0, minIdx = 0;
        int[] gradeCount = new int[4];
        int sum = 0, countAboveAvg = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
            char grade = getGrade(scores[i]);
            switch (grade) {
                case 'A' -> gradeCount[0]++;
                case 'B' -> gradeCount[1]++;
                case 'C' -> gradeCount[2]++;
                case 'D' -> gradeCount[3]++;
            }
            if (scores[i] > max) { max = scores[i]; maxIdx = i; }
            if (scores[i] < min) { min = scores[i]; minIdx = i; }
        }
        double avg = (double) sum / scores.length;
        for (int score : scores) if (score > avg) countAboveAvg++;
        System.out.println("=== 學生成績報告 ===");
        System.out.printf("總分：%d，平均：%.2f\n", sum, avg);
        System.out.printf("最高分：%d（學生 %d），最低分：%d（學生 %d）\n",
                max, maxIdx, min, minIdx);
        System.out.printf("A：%d 人，B：%d 人，C：%d 人，D：%d 人\n",
                gradeCount[0], gradeCount[1], gradeCount[2], gradeCount[3]);
        System.out.printf("高於平均的學生比例：%.2f%%\n",
                100.0 * countAboveAvg / scores.length);
        System.out.println("\n編號\t分數\t等級");
        System.out.println("----------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%2d\t%3d\t%c\n", i, scores[i], getGrade(scores[i]));
        }
    }
}