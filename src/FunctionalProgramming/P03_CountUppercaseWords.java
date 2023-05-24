package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> text = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));

        text = text.stream().filter(isUpperCase).collect(Collectors.toList());

        System.out.println(text.size());
        System.out.println(String.join("\n", text));
    }
}
