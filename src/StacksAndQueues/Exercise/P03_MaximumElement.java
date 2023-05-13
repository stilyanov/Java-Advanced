package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {

            String command = scanner.nextLine();

            if (command.startsWith("1")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                stack.push(x);
            } else if (command.startsWith("2")) {
                stack.pop();
            } else if (command.startsWith("3")){
                if (stack.size() > 0) {
                    System.out.println(Collections.max(stack));
                }
            }
        }
    }
}
