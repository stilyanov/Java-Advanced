package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double [] values = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        for (double value : values) {
            if (!numbers.containsKey(value)) {
                numbers.put(value, 1);
            } else {
                int occurrence = numbers.get(value) + 1;
                numbers.put(value, occurrence);
            }
        }

        for (Double key : numbers.keySet()) {
            System.out.println(String.format("%.1f -> %d", key, numbers.get(key)));
        }
    }
}
