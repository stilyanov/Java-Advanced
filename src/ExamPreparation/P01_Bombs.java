package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class P01_Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bombEffectsInput = scanner.nextLine().split(", ");
        String[] bombCasingsInput = scanner.nextLine().split(", ");

        ArrayDeque<Integer> bombEffectQueue = new ArrayDeque<>();
        for (String bomb : bombEffectsInput) {
            bombEffectQueue.offer(Integer.parseInt(bomb));
        }

        ArrayDeque<Integer> bombCasingStack = new ArrayDeque<>();
        for (String bomb : bombCasingsInput) {
            bombCasingStack.push(Integer.parseInt(bomb));
        }

        boolean isFulFill = false;

        int daturaBombs = 0, cherryBombs = 0, smokeDecoyBombs = 0;
        while (!bombEffectQueue.isEmpty() && !bombCasingStack.isEmpty()) {
            if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3){
                isFulFill = true;
                break;
            }
                int bombEffect = bombEffectQueue.peek();
            int bombCasing = bombCasingStack.peek();
            int sum = bombEffect + bombCasing;

            if (sum == 40) {
                daturaBombs++;
                bombEffectQueue.poll();
                bombCasingStack.pop();
            } else if (sum == 60) {
                cherryBombs++;
                bombEffectQueue.poll();
                bombCasingStack.pop();
            } else if (sum == 120) {
                smokeDecoyBombs++;
                bombEffectQueue.poll();
                bombCasingStack.pop();
            } else {
                int currentBombCasingValue = bombCasingStack.pop();
                bombCasingStack.push(currentBombCasingValue - 5);
            }
        }
//
//        TreeMap<String, Integer> bombsMap = new TreeMap<>();
//        bombsMap.put("Datura Bombs", daturaBombs); // 40
//        bombsMap.put("Cherry Bombs", cherryBombs); // 60
//        bombsMap.put("Smoke Decoy Bombs", smokeDecoyBombs); // 120

        if (isFulFill) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffectQueue.isEmpty()) {
            System.out.print("Bomb Effects: empty");
        } else {
            String result = bombEffectQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.print("Bomb Effects: " + result);
        }
        System.out.println();
        if (bombCasingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            String result = bombCasingStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Bomb Casings: " + result);
        }
        System.out.println("Cherry Bombs: " + cherryBombs);
        System.out.println("Datura Bombs: " + daturaBombs);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBombs);
    }
}
