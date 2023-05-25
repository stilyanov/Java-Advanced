package FunctionalProgramming.Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class P01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String> printNames = System.out::println;

        for (String name : names) {
            printNames.accept(name);
        }
    }
}
