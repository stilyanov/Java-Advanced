package ExamPreparation;

import java.util.Scanner;

public class P02_RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String racingCarNumber = scanner.nextLine();

        String[][] matrix = new String[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        int carRow = 0;
        int carCol = 0;
        int kilometers = 0;

        boolean isFinished = false;

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            kilometers += 10;
            switch (command) {
                case "left":
                    carCol--;
                    if (matrix[carRow][carCol].equals("T")) {
                        kilometers += 20;
                        for (int row = 0; row < size; row++) {
                            for (int col = 0; col < size; col++) {
                                if (matrix[row][col].equals("T")) {
                                    matrix[carRow][carCol] = ".";
                                    carRow = row;
                                    carCol = col;
                                    break;
                                }
                            }
                        }
                    } else if (matrix[carRow][carCol].equals("F")) {
                        isFinished = true;
                        break;
                    }
                    break;
                case "right":
                    carCol++;
                    if (matrix[carRow][carCol].equals("T")) {
                        kilometers += 20;
                        for (int row = 0; row < size; row++) {
                            for (int col = 0; col < size; col++) {
                                if (matrix[row][col].equals("T")) {
                                    matrix[carRow][carCol] = ".";
                                    carRow = row;
                                    carCol = col;
                                    break;
                                }
                            }
                        }
                    } else if (matrix[carRow][carCol].equals("F")) {
                        isFinished = true;
                        break;
                    }
                    break;
                case "up":
                    carRow--;
                    if (matrix[carRow][carCol].equals("T")) {
                        kilometers += 20;
                        for (int row = 0; row < size; row++) {
                            for (int col = 0; col < size; col++) {
                                if (matrix[row][col].equals("T")) {
                                    matrix[carRow][carCol] = ".";
                                    carRow = row;
                                    carCol = col;
                                    break;
                                }
                            }
                        }
                    } else if (matrix[carRow][carCol].equals("F")) {
                        isFinished = true;
                        break;
                    }
                    break;
                case "down":
                    carRow++;
                    if (matrix[carRow][carCol].equals("T")) {
                        kilometers += 20;
                        for (int row = 0; row < size; row++) {
                            for (int col = 0; col < size; col++) {
                                if (matrix[row][col].equals("T")) {
                                    matrix[carRow][carCol] = ".";
                                    carRow = row;
                                    carCol = col;
                                    break;
                                }
                            }
                        }
                    } else if (matrix[carRow][carCol].equals("F")) {
                        isFinished = true;
                        break;
                    }
            }
            matrix[carRow][carCol] = ".";

            if (!isFinished) {
                command = scanner.nextLine();
            } else {
                matrix[carRow][carCol] = "C";
                break;
            }
        }
        if (isFinished) {
            System.out.printf("Racing car %s finished the stage!%n", racingCarNumber);
        } else {
            matrix[carRow][carCol] = "C";
            System.out.printf("Racing car %s DNF.%n", racingCarNumber);
        }
        System.out.printf("Distance covered %d km.%n", kilometers);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
