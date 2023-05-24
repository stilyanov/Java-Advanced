package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> sumNumbers = list -> {
          int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            return sum;
        };

        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + sumNumbers.apply(numbers));
    }
}
