package ExamPreparation;

import java.util.*;

public class P01_ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] foodPortionsInput = scanner.nextLine().split("[,\\s]+");
        String[] staminaInput = scanner.nextLine().split("[,\\s]+");

        ArrayDeque<Integer> portions = new ArrayDeque<>(); // stack
        for (String portion : foodPortionsInput) {
            portions.push(Integer.parseInt(portion));
        }

        ArrayDeque<Integer> stamina = new ArrayDeque<>(); // queue
        for (String st : staminaInput) {
            stamina.offer(Integer.parseInt(st));
        }

        LinkedHashMap<String, Integer> peaksMap = new LinkedHashMap<>();
        peaksMap.put("Vihren", 80);
        peaksMap.put("Kutelo", 90);
        peaksMap.put("Banski Suhodol", 100);
        peaksMap.put("Polezhan", 60);
        peaksMap.put("Kamenitza", 70);

        List<String> conqueredPeaks = new ArrayList<>();

        Deque<String> peaks = new ArrayDeque<>(Arrays.asList("Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza"));

        while (!portions.isEmpty() && !stamina.isEmpty() && !peaks.isEmpty()) {
            int portion = portions.peek();
            int oneStamina = stamina.peek();
            int sum = portion + oneStamina;

            String currentPeak = peaks.getFirst();
            if (sum >= peaksMap.get(currentPeak)) {
                conqueredPeaks.add(currentPeak);
                portions.pop();
                stamina.poll();
                peaksMap.remove(currentPeak);
                peaks.removeFirst();
            } else {
                portions.pop();
                stamina.poll();
            }
        }
        System.out.println(peaks.isEmpty()
                ? "Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK"
                : "Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            conqueredPeaks.forEach(System.out::println);
        }
    }
}
