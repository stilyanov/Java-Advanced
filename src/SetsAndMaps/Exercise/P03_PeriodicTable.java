package SetsAndMaps.Exercise;

import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class P03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<String> chemicalSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] chemicals = scanner.nextLine().split("\\s+");
            chemicalSet.addAll(List.of(chemicals));
        }

        chemicalSet.forEach(el -> System.out.print(el + " "));
    }
}
