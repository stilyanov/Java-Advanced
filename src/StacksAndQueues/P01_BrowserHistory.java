package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> urlStack = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (urlStack.isEmpty() || urlStack.size() == 1) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
                urlStack.pop();

            } else {
                urlStack.push(input);

            }
            System.out.println(urlStack.peek());
            input = scanner.nextLine();
        }

    }
}
