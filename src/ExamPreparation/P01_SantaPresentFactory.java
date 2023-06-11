package ExamPreparation;

import java.util.*;

public class P01_SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] materialsInput = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> materials = new ArrayDeque<>();
        for (String material : materialsInput) {
            materials.push(Integer.parseInt(material));
        }

        String[] magicsInput = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> magics = new ArrayDeque<>();
        for (String magic : magicsInput) {
            magics.offer(Integer.parseInt(magic));
        }

        int countDoll = 0, countTrain = 0, countBear = 0, countBicycle = 0;

        while (!materials.isEmpty() && !magics.isEmpty()) {
            int material = materials.peek();
            int magic = magics.peek();
            int magicSum = material * magic;

            if (magicSum == 150) {
                materials.pop();
                magics.poll();
                countDoll++;
            } else if (magicSum == 250) {
                materials.pop();
                magics.poll();
                countTrain++;
            } else if (magicSum == 300) {
                materials.pop();
                magics.poll();
                countBear++;
            } else if (magicSum == 400) {
                materials.pop();
                magics.poll();
                countBicycle++;
            } else if (magicSum < 0) {
                int sum = material + magic;
                materials.pop();
                magics.poll();
                materials.push(sum);
            } else if (magicSum > 0) {
                magics.poll();
                materials.push(materials.pop() + 15);
            } else {
                if (magic == 0) {
                    magics.poll();
                }
                if (material == 0) {
                    materials.pop();
                }
            }
        }

        TreeMap<String, Integer> presents = new TreeMap<>();
        presents.put("Doll", countDoll);
        presents.put("Wooden train", countTrain);
        presents.put("Teddy bear", countBear);
        presents.put("Bicycle", countBicycle);


        boolean isDollAndTrain = presents.get("Doll") > 0 && presents.get("Wooden train") > 0;
        boolean isBearAndBicycle = presents.get("Teddy bear") > 0 && presents.get("Bicycle") > 0;

        if (isDollAndTrain || isBearAndBicycle) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(materials.toString().replace("[", "").replace("]", ""));
        }

        if (!magics.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(magics.toString().replace("[", "").replace("]", ""));
        }

        for (Map.Entry<String, Integer> entry : presents.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

    }
}
