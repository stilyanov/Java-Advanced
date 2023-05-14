package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(", ")[0]);
        int cows = Integer.parseInt(input.split(", ")[1]);

        int[][] matrix = new int[rows][cows];

        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            int[] current = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < current.length; col++) {
                sum += current[col];
            }

            matrix[row] = current;
        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        System.out.println(sum);
    }
}
