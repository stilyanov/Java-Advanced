package RegularExam;

import java.util.Scanner;

public class secondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(",");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        int mouseRow = -1;
        int mouseCol = -1;
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            char[] rowData = scanner.nextLine().toCharArray();
            matrix[row] = rowData;
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        boolean isTrap = false;

        int countCheese = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'C') {
                    countCheese++;
                }
            }
        }
        int eatenCheese = 0;
        boolean isDanger = false;

        String command = scanner.nextLine();
        while (!command.equals("danger")) {

            if (command.equals("danger")) {
                isDanger = true;
            }
            int newMouseRow = mouseRow;
            int newMouseCol = mouseCol;

            switch (command) {
                case "left":
                    newMouseCol--;
                    break;
                case "right":
                    newMouseCol++;
                    break;
                case "up":
                    newMouseRow--;
                    break;
                case "down":
                    newMouseRow++;
                    break;
            }

            if (isOutOfBound(newMouseRow, rows, newMouseCol, cols)) {
                System.out.println("No more cheese for tonight!");
                break;
            }

            if (matrix[newMouseRow][newMouseCol] == '@') {
                command = scanner.nextLine();
                continue;

            } else if (matrix[newMouseRow][newMouseCol] == 'C') {
                eatenCheese++;
                matrix[newMouseRow][newMouseCol] = '*';

                if (countCheese == eatenCheese) {
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                }

            } else if (matrix[newMouseRow][newMouseCol] == 'T') {
                isTrap = true;
                matrix[mouseRow][mouseCol] = '*';
                matrix[newMouseRow][newMouseCol] = 'M';
                break;
            }

            matrix[mouseRow][mouseCol] = '*';
            matrix[newMouseRow][newMouseCol] = 'M';
            mouseRow = newMouseRow;
            mouseCol = newMouseCol;

            command = scanner.nextLine();
        }
        if (isTrap) {
            System.out.println("Mouse is trapped!");
        } else if (isDanger) {
            System.out.println("Mouse will come back later!");
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static boolean isOutOfBound(int newMouseRow, int rows, int newMouseCol, int cols) {
        return newMouseRow < 0 || newMouseRow >= rows || newMouseCol < 0 || newMouseCol >= cols;
    }
}
