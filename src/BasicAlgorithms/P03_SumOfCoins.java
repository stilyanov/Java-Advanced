package BasicAlgorithms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_SumOfCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().substring(7).split("\\s+");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(scanner.nextLine().substring(5));

        Map<Integer, Integer> usedCoins;
        try {
            usedCoins = chooseCoins(coins, targetSum);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return;
        }
        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    private static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> coinsAmount = new LinkedHashMap<>();

        int index = coins.length - 1;

        while (targetSum != 0 && index >= 0) {
            int coin = coins[index--];
            int coinsToTake = targetSum / coin;
            targetSum = targetSum % coin;

            if (coinsToTake != 0) {
                coinsAmount.put(coin, coinsToTake);
            }
        }

        if (targetSum != 0) {
            throw new IllegalStateException("Error");
        }
        return coinsAmount;
    }
}
