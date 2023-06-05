package Generics.Exercise.GenerixBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Double> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            box.add(Double.parseDouble(input));

        }
        String elementToCompare = scanner.nextLine();
        System.out.println(box.countOfGreaterItems(Double.parseDouble(elementToCompare)));
    }
}
