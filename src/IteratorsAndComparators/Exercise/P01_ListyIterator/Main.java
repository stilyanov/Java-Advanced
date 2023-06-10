package IteratorsAndComparators.Exercise.P01_ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListyIterator iterator = null;

        String input = scanner.nextLine();
        while (!input.equals("END")) {
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
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
                case "Print":
                    try {
                        iterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
            }


            input = scanner.nextLine();
        }
    }
}
