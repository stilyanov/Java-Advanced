package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] caffeineInput = scanner.nextLine().split(", ");
        String[] energyDrinkInput = scanner.nextLine().split(", ");

        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();
        for (String coffee : caffeineInput) {
            caffeineStack.push(Integer.parseInt(coffee));
        }

        ArrayDeque<Integer> energyDrinkQueue = new ArrayDeque<>();
        for (String energyDrink : energyDrinkInput) {
            energyDrinkQueue.offer(Integer.parseInt(energyDrink));
        }


        int maximumCaffeine = 300;
        int totalCaffeine = 0;

        while (!caffeineStack.isEmpty() && !energyDrinkQueue.isEmpty()) {
            int caffeine = caffeineStack.peek();
            int energyDrink = energyDrinkQueue.peek();
            int sum = caffeine * energyDrink;

            if (sum + totalCaffeine <= maximumCaffeine) {
                caffeineStack.pop();
                energyDrinkQueue.poll();
                totalCaffeine += sum;
            } else {
                caffeineStack.pop();
                energyDrinkQueue.poll();
                energyDrinkQueue.offer(energyDrink);
                if (totalCaffeine >= 30) {
                    totalCaffeine -= 30;
                }
            }
        }

        if (!energyDrinkQueue.isEmpty()) {
            System.out.printf("Drinks left: %s%n", String.join(", ",
                    Arrays.asList(energyDrinkQueue.toString().substring(1, energyDrinkQueue.toString().length() - 1))));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %s mg caffeine.", totalCaffeine);
    }
}
