package SetsAndMaps.Exercise;

import java.util.HashMap;
import java.util.Scanner;

public class P05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, String> informationMap = new HashMap<>();

        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];

            informationMap.put(name, number);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")) {
            if (informationMap.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, informationMap.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }


            input = scanner.nextLine();
        }
    }
}
