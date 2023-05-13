package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> numberStack = new ArrayDeque<>();

        Arrays.stream(input.split("\\s+")).forEach(number -> numberStack.push(Integer.valueOf(number)));

        while (!numberStack.isEmpty()) {
            System.out.print(numberStack.pop() + " ");
        }
    }
}
