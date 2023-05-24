package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P06_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bounds = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String condition = scanner.nextLine();

        Predicate<Integer> isEven = n -> n % 2 == 0;
        printNumbers(bounds, condition, isEven);
    }

    private static void printNumbers(int[] bounds, String condition, Predicate<Integer> isEven) {
        int lowerBound = bounds[0];
        int upperBound = bounds[1];

        if (condition.equals("odd")) {
            for (int i = lowerBound; i <= upperBound; i++) {
                if (!isEven.test(i)) {
                    System.out.print(i + " ");
                }
            }
        } else {
            for (int i = lowerBound; i <= upperBound; i++) {
                if (isEven.test(i)) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
