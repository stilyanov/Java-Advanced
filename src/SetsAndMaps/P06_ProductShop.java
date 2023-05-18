package SetsAndMaps;

import com.sun.source.tree.Tree;

import java.util.*;

public class P06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        Map<String, LinkedHashMap<String, Double>> informationShops = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] inputData = input.split(", ");
            //{shop}, {product}, {price}
            String shop = inputData[0];
            String product = inputData[1];
            double price = Double.parseDouble(inputData[2]);

            if (!informationShops.containsKey(shop)) {
                informationShops.put(shop, new LinkedHashMap<>());
                informationShops.get(shop).put(product, price);
            } else {
                informationShops.get(shop).put(product, price);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> currentShop : informationShops.entrySet()) {
            System.out.printf("%s->%n", currentShop.getKey());
            for (Map.Entry<String, Double> currentProduct : currentShop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", currentProduct.getKey(), currentProduct.getValue());
            }
        }
    }
}
