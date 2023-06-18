package RegularExam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class firstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] toolsInput = scanner.nextLine().split(" ");
        String[] substancesInput = scanner.nextLine().split(" ");
        String[] challengesInput = scanner.nextLine().split(" ");

        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();
        for (String tool : toolsInput) {
            toolsQueue.offer(Integer.parseInt(tool));
        }

        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();
        for (String substance : substancesInput) {
            substancesStack.push(Integer.parseInt(substance));
        }

        List<Integer> challengesList = new ArrayList<>();
        for (String challenge : challengesInput) {
            challengesList.add(Integer.parseInt(challenge));
        }

        boolean hasAtLeastOne = false;

        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty() && !challengesList.isEmpty()) {
            int tool = toolsQueue.poll();
            int substance = substancesStack.pop();
            int sum = tool * substance;

            for (int i = 0; i < challengesList.size(); i++) {
                int challenge = challengesList.get(i);
                if (sum == challenge) {
                    challengesList.remove(i);
                    hasAtLeastOne = true;
                    break;
                }
            }

            if (!hasAtLeastOne) {
                toolsQueue.addLast(tool + 1);
                if (substance - 1 > 0) {
                    substancesStack.push(substance - 1);
                }
            }
            hasAtLeastOne = false;
        }
        if (!challengesList.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }

        if (!toolsQueue.isEmpty()) {
            String result = toolsQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Tools: " + result);
        }
        if (!substancesStack.isEmpty()) {
            String result = substancesStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Substances: " + result);
        }
        if (!challengesList.isEmpty()) {
            String result = challengesList.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Challenges: " + result);
        }
    }
}
