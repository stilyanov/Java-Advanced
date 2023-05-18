package SetsAndMaps;

import java.util.Scanner;
import java.util.TreeSet;

public class P02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeSet<String> vipSet = new TreeSet<>();
        TreeSet<String> regularSet = new TreeSet<>();

        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vipSet.add(input);
            } else {
                regularSet.add(input);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("END")) {
            if (Character.isDigit(input.charAt(0))) {
                vipSet.remove(input);
            } else {
                regularSet.remove(input);
            }


            input = scanner.nextLine();
        }

        System.out.println(vipSet.size() + regularSet.size());
        if (!vipSet.isEmpty()) {
            vipSet.forEach(System.out::println);
        }
        if (!regularSet.isEmpty()) {
            regularSet.forEach(System.out::println);
        }
    }
}
