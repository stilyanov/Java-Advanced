package SetsAndMaps;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P09_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sorted = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        if (sorted.size() <= 3) {
            sorted.forEach(item -> System.out.printf("%d ", item));
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.printf("%d ", sorted.get(i));
            }
        }

    }
}
