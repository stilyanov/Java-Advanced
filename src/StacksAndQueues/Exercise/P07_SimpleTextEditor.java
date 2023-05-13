package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder currentText = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();
            if (command.startsWith("1")) {
                //• "1 {string}" - appends [string] to the end of the text.
                stack.push(currentText.toString());
                String textToAppend = command.split("\\s+")[1];
                currentText.append(textToAppend);

            } else if (command.startsWith("2")) {
                //• "2 {count}" - erases the last [count] elements from the text.
                int count = Integer.parseInt(command.split("\\s+")[1]);
                stack.push(currentText.toString());
                int startIndex = currentText.length() - count;
                currentText.delete(startIndex, currentText.length());

            } else if (command.startsWith("3")) {
                //• "3 {index}" - returns the element at position [index] from the text.
                int index = Integer.parseInt(command.split("\\s+")[1]);
                System.out.println(currentText.charAt(index - 1));

            } else if (command.startsWith("4")) {
                //"4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation.
                if (!stack.isEmpty()) {
                    String last = stack.pop();
                    currentText = new StringBuilder(last);
                }
            }
        }
    }
}
