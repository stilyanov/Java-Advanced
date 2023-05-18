package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String carInput = scanner.nextLine();
        LinkedHashSet<String> carSet = new LinkedHashSet<>();

        while (!carInput.equals("END")) {
            String[] inputArr = carInput.split(", ");
            String command = inputArr[0];
            String carNumber = inputArr[1];

            if (command.equals("IN")) {
                carSet.add(carNumber);
            } else if (command.equals("OUT")) {
                carSet.remove(carNumber);
            }

            carInput = scanner.nextLine();
        }

        if (carSet.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : carSet) {
                System.out.println(car);
            }
        }
    }
}
