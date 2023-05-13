package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> urlStack = new ArrayDeque<>();
        ArrayDeque<String> forwardQueue = new ArrayDeque<>();

        String currentUrl;
        String forward;

        String input = scanner.nextLine();
        while (!input.equals("Home")) {

            if (input.equals("back")) {

                if (urlStack.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    currentUrl = urlStack.pop();
                    forwardQueue.push(currentUrl);
                    System.out.println(urlStack.peek());
                }

            } else if (input.equals("forward")) {

                if (forwardQueue.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    forward = forwardQueue.pop();
                    System.out.println(forward);
                    urlStack.push(forward);
                }

            } else {
                urlStack.push(input);
                System.out.println(input);
                forwardQueue.clear();
            }

            input = scanner.nextLine();
        }
    }
}
