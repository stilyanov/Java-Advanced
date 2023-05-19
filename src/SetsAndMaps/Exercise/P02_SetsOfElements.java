package SetsAndMaps.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int firstSetSize = Integer.parseInt(input.split("\\s+")[0]);
        int secondSetSize = Integer.parseInt(input.split("\\s+")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int i = 0; i < secondSetSize; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

//        Set<Integer> dublicateElements = new LinkedHashSet<>();
//        for (int number : firstSet) {
//            if(secondSet.contains(number)) {
//                dublicateElements.add(number);
//            }
//        }
//        for (Integer number : dublicateElements) {
//            System.out.print(number + " ");
//        }
        firstSet.retainAll(secondSet);
        firstSet.forEach(number -> System.out.print(number + " "));
    }
}
