package SetsAndMaps.Exercise;

import java.util.*;

public class P07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        LinkedHashMap<String, Set<String>> playersMap = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String name = input.split(":\\s+")[0];
            String cards = input.split(":\\s+")[1];
            String[] cardsArr = cards.split(", ");
            Set<String> cardsSet = new HashSet<>();

            cardsSet.addAll(Arrays.asList(cardsArr));

            if (!playersMap.containsKey(name)) {
                playersMap.put(name, cardsSet);
            } else {
                Set<String> currentCards = playersMap.get(name);
                currentCards.addAll(cardsSet);
                playersMap.put(name, currentCards);
            }

            input = scanner.nextLine();
        }
        playersMap.entrySet().forEach(entry -> {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int points = getCardsPoints(cards);
            System.out.printf("%s: %d%n", name, points);
        });
    }

    private static int getCardsPoints(Set<String> cards) {

        Map<Character, Integer> symbols = getSymbolsValues();
        int sum = 0;

        for (String card : cards) {
            int points = 0;
            if (card.startsWith("10")) {
                char type = card.charAt(2);
                points = 10 * symbols.get(type);
            } else {
                char power = card.charAt(0);
                char type = card.charAt(1);
                points = symbols.get(power) * symbols.get(type);
            }
            sum += points;
        }
        return sum;
    }

    private static Map<Character, Integer> getSymbolsValues() {
        Map<Character, Integer> characterValues = new HashMap<>();
        characterValues.put('2', 2);
        characterValues.put('3', 3);
        characterValues.put('4', 4);
        characterValues.put('5', 5);
        characterValues.put('6', 6);
        characterValues.put('7', 7);
        characterValues.put('8', 8);
        characterValues.put('9', 9);
        characterValues.put('J', 11);
        characterValues.put('Q', 12);
        characterValues.put('K', 13);
        characterValues.put('A', 14);
        characterValues.put('S', 4);
        characterValues.put('H', 3);
        characterValues.put('D', 2);
        characterValues.put('C', 1);
        return characterValues;
    }
}
