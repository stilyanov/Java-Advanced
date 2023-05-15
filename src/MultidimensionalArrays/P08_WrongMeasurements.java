package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        }
        int rowPosition = scanner.nextInt();
        int colPosition = scanner.nextInt();
        int wrongValue = matrix[rowPosition][colPosition];
        int newValue = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNum = matrix[row][col];
                if (currentNum == wrongValue) {

                    if (!(row - 1 < 0) && matrix[row - 1][col] != wrongValue) {
                        newValue += matrix[row - 1][col];

                    }
                    if (!(col + 1 > matrix[row].length - 1) && matrix[row][col + 1] != wrongValue) {
                        newValue += matrix[row][col + 1];

                    }
                    if (!(col - 1 < 0) && matrix[row][col - 1] != wrongValue) {
                        newValue += matrix[row][col - 1];

                    }
                    if (!(row + 1 > matrix.length - 1) && matrix[row + 1][col] != wrongValue) {
                        newValue += matrix[row + 1][col];

                    }
                    System.out.printf("%d ", newValue);
                } else {
                    System.out.printf("%d ", matrix[row][col]);
                }
                newValue = 0;
            }
            System.out.println();
        }
    }
}
