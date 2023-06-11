package ExamPreparation;

import java.util.Scanner;

public class P02_BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder(text);
        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);

        int playerRow = -1;
        int playerCol = -1;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("P")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            int startRow = playerRow;
            int startCol = playerCol;
            boolean isOutside = false;
            switch (command) {
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        playerRow++;
                        isOutside = true;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow >= size) {
                        playerRow--;
                        isOutside = true;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        playerCol++;
                        isOutside = true;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol >= size) {
                        playerCol--;
                        isOutside = true;
                    }
                    break;
            }

            if (!isOutside) {
                String currentText = matrix[playerRow][playerCol];
                if (!currentText.equals("-")) {
                    sb.append(currentText);
                }
                matrix[playerRow][playerCol] = "P";
                matrix[startRow][startCol] = "-";
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            command = scanner.nextLine();
        }

        System.out.println(sb);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row <= matrix.length - 1; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
