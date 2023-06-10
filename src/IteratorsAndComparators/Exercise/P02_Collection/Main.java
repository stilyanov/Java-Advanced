package IteratorsAndComparators.Exercise.P02_Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ListyIterator iterator = null;

        while (!"END".equals(input)) {
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];

            switch (command) {
                case "Create":
                    if (commandParts.length > 1) {
                        String[] items = Arrays.copyOfRange(commandParts, 1, commandParts.length);
                        iterator = new ListyIterator(items);
                    } else {
                        iterator = new ListyIterator();
                    }
                    break;

                case "Move":
                    System.out.println(iterator.move());

                    break;
                case "PrintAll":
                    iterator.printAll();
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;

                case "Print":
                    try {
                        iterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println("Invalid Operation!");
                    }
            }

            input = scanner.nextLine();
        }
    }
}
