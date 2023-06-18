package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01_KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] licensePlatesInput = scanner.nextLine().split(", ");
        String[] carsInput = scanner.nextLine().split(", ");

        ArrayDeque<Long> licensePlateQueue = new ArrayDeque<>();
        for (String licencePlace : licensePlatesInput) {
            licensePlateQueue.offer(Long.parseLong(licencePlace));
        }

        ArrayDeque<Long> carsStack = new ArrayDeque<>();
        for (String car : carsInput) {
            carsStack.push(Long.parseLong(car));
        }

        int registeredCars = 0;
        int countDays = 0;

        while (!carsStack.isEmpty() && !licensePlateQueue.isEmpty()) {
            countDays++;
            long licensePlate = licensePlateQueue.poll();
            long car = carsStack.pop();

            if (licensePlate > car * 2) {
                licensePlate -= car * 2;
                registeredCars += car;
                licensePlateQueue.addLast(licensePlate);
            } else if (licensePlate < car * 2) {
                car -= licensePlate / 2;
                registeredCars += licensePlate / 2;
                carsStack.addFirst(car);
            } else {
                registeredCars += car;
            }
        }
        System.out.printf("%d cars were registered for %d days!\n" ,registeredCars ,countDays);
        if (!licensePlateQueue.isEmpty()) {
            long sum = 0;
            for (long num : licensePlateQueue) {
                sum += num;
            }
            System.out.printf("%d license plates remain!\n", sum);
        } else if (!carsStack.isEmpty()){
            long sum = 0;
            for (long num : carsStack) {
                sum += num;
            }
            System.out.printf("%d cars remain without license plates!\n", sum);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
