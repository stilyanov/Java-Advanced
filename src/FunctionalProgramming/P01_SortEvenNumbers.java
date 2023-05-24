package FunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class P01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        printList(numbers);

        Collections.sort(numbers);

        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        List<String> numbersAsText = new ArrayList<>();
        for (Integer number : numbers) {
            numbersAsText.add(number.toString());
        }
        System.out.println(String.join(", ", numbersAsText));
    }
}
