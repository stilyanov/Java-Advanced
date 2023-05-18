package SetsAndMaps;

import java.util.*;

public class P07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> infoMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String continent = inputData[0];
            String country = inputData[1];
            String city = inputData[2];

            if (!infoMap.containsKey(continent)) {
                infoMap.put(continent, new LinkedHashMap<>());
                infoMap.get(continent).put(country, new ArrayList<>());
                infoMap.get(continent).get(country).add(city);
            } else {
                if (!infoMap.get(continent).containsKey(country)) {
                    infoMap.get(continent).put(country, new ArrayList<>());
                    infoMap.get(continent).get(country).add(city);
                } else {
                    infoMap.get(continent).get(country).add(city);
                }
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> currentContinent : infoMap.entrySet()) {
            System.out.printf("%s:%n", currentContinent.getKey());
            for (Map.Entry<String, List<String>> currentCountry : currentContinent.getValue().entrySet()) {
                System.out.printf("  %s -> ", currentCountry.getKey());
                System.out.print(String.join(", ", currentCountry.getValue()));
                System.out.println();
            }
        }
    }
}
