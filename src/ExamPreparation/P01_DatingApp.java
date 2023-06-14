package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] maleInput = scanner.nextLine().split("\\s+");
        String[] femaleInput = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();

        for (String male : maleInput) {
            maleStack.push(Integer.parseInt(male));
        }

        for (String female : femaleInput) {
            femaleQueue.offer(Integer.parseInt(female));
        }

        int matches = 0;

        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            int male = maleStack.peek();
            int female = femaleQueue.peek();


            if (male <= 0) {
                maleStack.pop();
                continue;
            }
            if (female <= 0) {
                femaleQueue.poll();
                continue;
            }

            if (male % 25 == 0) {
                maleStack.poll();
                maleStack.poll();
                continue;
            }
            if (female % 25 == 0) {
                femaleQueue.poll();
                femaleQueue.poll();
                continue;
            }

            if (male == female) {
                matches++;
                maleStack.pop();
                femaleQueue.poll();
            } else {
                femaleQueue.poll();
                int maleToRemove = maleStack.pop();
                maleStack.push(maleToRemove - 2);
            }
        }
        System.out.println("Matches: " + matches);

        System.out.printf("Males left: %s%n", result(maleStack));
        System.out.printf("Females left: %s", result(femaleQueue));
    }

    private static String result(ArrayDeque<Integer> arrayDeque) {
        String result = "none";

        if (!arrayDeque.isEmpty()) {
            result = arrayDeque.stream().map(String::valueOf).collect(Collectors.joining(", "));
        }
        return result;
    }
}
