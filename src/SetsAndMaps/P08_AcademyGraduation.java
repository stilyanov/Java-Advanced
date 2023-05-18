package SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class P08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> studentMap = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String name = scanner.nextLine();
            List<Double> score = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            if (!studentMap.containsKey(name)) {
                studentMap.put(name, score);
            } else {
                studentMap.get(name).addAll(score);
            }
        }

        for (Map.Entry<String, List<Double>> student : studentMap.entrySet()) {
            String currentStudent = student.getKey();
            int degreeCount = student.getValue().size();
            double degreeSum = getSumDegrees(student.getValue());
            double average = degreeSum / degreeCount;
            System.out.println(String.format("%s is graduated with %s", currentStudent, average));
        }
    }

    private static double getSumDegrees(List<Double> value) {
        double sum = 0d;
        for (int i = 0; i < value.size(); i++) {
            sum+= value.get(i);
        }
        return sum;
    }
}
