package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();

        boolean areBalanced = false;

        for (Character bracket : input.toCharArray()) {

            if (bracket == '(' || bracket == '[' || bracket == '{') {
                openBracketsStack.push(bracket);

            } else if (bracket == ')' || bracket == ']' || bracket == '}') {

                if (openBracketsStack.isEmpty()) {
                    areBalanced = false;
                    break;
                }

                char lastOpenBracket = openBracketsStack.pop();

                if (lastOpenBracket == '(' && bracket == ')') {
                    areBalanced = true;

                } else if (lastOpenBracket == '[' && bracket == ']') {
                    areBalanced = true;

                } else if (lastOpenBracket == '{' && bracket == '}') {
                    areBalanced = true;

                } else {
                    areBalanced = false;
                    break;
                }

            }
        }
        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
