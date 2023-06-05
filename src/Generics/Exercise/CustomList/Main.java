package Generics.Exercise.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();

        String inputData = scanner.nextLine();
        while (!inputData.equals("END")) {
            String[] command = inputData.split("\\s+");
            switch (command[0]) {
                case "Add":
                    String elementToAdd = command[1];
                    list.add(elementToAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(command[1]);
                    list.remove(index);
                    break;
                case "Contains":
                    String containsElement = command[1];
                    System.out.println(list.contains(containsElement));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);
                    list.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String greaterElement = command[1];
                    System.out.println(list.countGreaterThan(greaterElement));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    System.out.println(list);
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
            }


            inputData = scanner.nextLine();
        }
    }
}
