package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06_RecursiveFibonacci2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(0L);
        stack.push(1L);

        for (int i = 1; i <= n; i++) {
            long first = stack.pop();
            long second = stack.pop();
            stack.push(first);
            long sum = first + second;
            stack.push(sum);
        }
        System.out.println(stack.peek());
    }
}
