package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> numberStack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            numberStack.push(scanner.nextInt());
        }

        for (int i = 1; i <= s; i++) {
            numberStack.pop();
        }

        if (numberStack.contains(x)) {
            System.out.println("true");
        } else {
            if (numberStack.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(numberStack));
            }
        }
    }
}
