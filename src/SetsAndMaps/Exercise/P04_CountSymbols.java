package SetsAndMaps.Exercise;

import java.util.Scanner;
import java.util.TreeMap;

public class P04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        TreeMap<Character, Integer> symbolsCountMap = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (symbolsCountMap.containsKey(currentSymbol)) {
                int currentCount = symbolsCountMap.get(currentSymbol);
                symbolsCountMap.put(currentSymbol, currentCount + 1);
            } else {
                symbolsCountMap.put(currentSymbol, 1);
            }
        }
        symbolsCountMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s"));
    }
}
