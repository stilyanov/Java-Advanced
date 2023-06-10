package ExamPreparation;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class P01_ApocalypsePreparation {
    private static final int PATCH_VALUE = 30;
    private static final int BANDAGE_VALUE = 40;
    private static final int MEDKIT_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] textilesData = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        for (String textile : textilesData) {
            textiles.offer(Integer.parseInt(textile));
        }

        String[] medicamentsData = scanner.nextLine().split("\\s+");
        Stack<Integer> medicaments = new Stack<>();
        for (String medicament : medicamentsData) {
            medicaments.push(Integer.parseInt(medicament));
        }

        int patchCount = 0, bandageCount = 0, medkitCount = 0;
        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int textile = textiles.poll();
            int medicament = medicaments.pop();
            int sum = textile + medicament;

            if (sum == PATCH_VALUE) {
                patchCount++;
            } else if (sum == BANDAGE_VALUE) {
                bandageCount++;
            } else if (sum == MEDKIT_VALUE) {
                medkitCount++;
            } else if (sum > MEDKIT_VALUE) {
                medkitCount++;
                int remaining = sum - MEDKIT_VALUE;
                medicaments.push(medicaments.pop() + remaining);
            } else {
                medicaments.push(medicament + 10);
            }
        }
        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Patch", patchCount);
        map.put("Bandage", bandageCount);
        map.put("MedKit", medkitCount);
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> {
                    if (entry.getValue() != 0) {
                        System.out.println(entry.getKey() + " - " + entry.getValue());
                    }
                });

        if (!textiles.isEmpty()) {
            System.out.print("Textiles left: ");
            while (!textiles.isEmpty()) {
                if (textiles.size() > 1) {
                    System.out.print(textiles.poll() + ", ");
                } else {
                    System.out.print(textiles.poll());
                }

            }
        }

        if (!medicaments.isEmpty()) {
            System.out.print("Medicaments left: ");
            while (!medicaments.isEmpty()) {
                if (medicaments.size() > 1) {
                    System.out.print(medicaments.pop() + ", ");
                } else {
                    System.out.print(medicaments.pop());
                }
            }
        }
    }
}
