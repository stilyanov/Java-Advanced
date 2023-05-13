package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        PriorityQueue<String> namesQueue = new PriorityQueue<>();
        Arrays.stream(input.split("\\s+")).forEach(name -> namesQueue.offer(name));
        int turns = Integer.parseInt(scanner.nextLine());
        int cycle = 1;


        while (namesQueue.size() > 1) {
            for (int i = 1; i < turns; i++) {
                namesQueue.offer(namesQueue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + namesQueue.peek());
            } else {
                System.out.println("Removed " + namesQueue.poll());
            }

            cycle++;

        }
        System.out.println("Last is " + namesQueue.poll());
    }

    public static boolean isPrime (int cycle) {
        if (cycle == 1) {
            return false;
        }
        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
}
