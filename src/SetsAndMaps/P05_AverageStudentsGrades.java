package SetsAndMaps;

import java.util.*;

public class P05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentGrade = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            studentGrade.putIfAbsent(name, new ArrayList<>());
            studentGrade.get(name).add(grade);
        }

        studentGrade.forEach((student, grade) -> {
            double averageGrade = 0;
            for (double number : grade) {
                averageGrade += number;
            }
            averageGrade /= grade.size();
            System.out.printf("%s -> ", student);
            grade.forEach(g -> System.out.printf("%.2f ", g));
            System.out.printf("(avg: %.2f)%n", averageGrade);
        });
    }
}
