package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraysCount = scanner.nextInt();
        int sizeOfArray = scanner.nextInt();

        int[][] firstMatrix = new int[arraysCount][sizeOfArray];
        for (int i = 0; i < arraysCount; i++) {
            for (int j = 0; j < sizeOfArray; j++) {
                firstMatrix[i][j] = scanner.nextInt();
            }
        }

        arraysCount = scanner.nextInt();
        sizeOfArray = scanner.nextInt();

        int[][] secondMatrix = new int[arraysCount][sizeOfArray];
        for (int i = 0; i < arraysCount; i++) {
            for (int j = 0; j < sizeOfArray; j++) {
                secondMatrix[i][j] = scanner.nextInt();
            }
        }

        String output = Arrays.deepEquals(firstMatrix, secondMatrix) ? "equal" : "not equal";
        System.out.println(output);


//        boolean isEqual = compareArrays(firstMatrix, secondMatrix);
//        System.out.println(isEqual ? "equal" : "not equal");
    }

//    public static boolean compareArrays(int[][] firstMatrix, int[][] secondMatrix) {
//        if (firstMatrix.length != secondMatrix.length) {
//            return false;
//        }
//
//        for (int row = 0; row < firstMatrix.length; row++) {
//            if (firstMatrix[row].length != secondMatrix[row].length) {
//                return false;
//            }
//
//            for (int col = 0; col < firstMatrix[row].length; col++) {
//                if (firstMatrix[row][col] != secondMatrix[row][col]) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
