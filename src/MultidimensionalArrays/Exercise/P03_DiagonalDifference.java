package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        fillMatrix(matrix, scanner);

        int sumPrimary = getPrimaryDiagonalSum(matrix);

        int secondDiagonal = getSecondDiagonalSum(matrix);

        System.out.println(Math.abs(sumPrimary - secondDiagonal));
    }

    private static int getSecondDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col];
                if (col == matrix.length - row - 1) {
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    public static int getPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col];
                if (row == col) {
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    public static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
