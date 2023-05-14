package MultidimensionalArrays;

import java.util.Scanner;

public class P02_PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraysCount = scanner.nextInt();
        int sizeOfArray = scanner.nextInt();

        int[][] matrix = new int[arraysCount][sizeOfArray];
        for (int i = 0; i < arraysCount; i++) {
            for (int j = 0; j < sizeOfArray; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int searchNumber = scanner.nextInt();

        boolean isFound = false;

        for (int array = 0; array < matrix.length; array++) {
            for (int element = 0; element < matrix[array].length; element++) {
                if (matrix[array][element] == searchNumber) {
                    System.out.println(array + " " + element);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
}
