package ExamPreparation;

import java.util.Scanner;

public class P02_Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] territory = new char[size][size];

        int snakeRow = -1;
        int snakeCol = -1;

        for (int row = 0; row < size; row++) {
            char[] rowData = scanner.nextLine().toCharArray();
            territory[row] = rowData;
            for (int col = 0; col < size; col++) {
                if (territory[row][col] == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                }
            }
        }
        int eatenFood = 0;

        boolean isOutSide = false;

        String command = scanner.nextLine();
        while (eatenFood <= 10) {
            territory[snakeRow][snakeCol] = '.';
            switch (command) {
                case "left":
                    snakeCol--;
                    if (isInside(snakeCol, size)) {
                        if (territory[snakeRow][snakeCol] == 'B') {
                            for (int row = 0; row < size; row++) {
                                for (int col = 0; col < size; col++) {
                                    if (territory[snakeRow][snakeCol] == 'B') {
                                        territory[snakeRow][snakeCol] = 'S';
                                        snakeRow = row;
                                        snakeCol = col;
                                        break;
                                    }
                                }
                            }
                        } else if (territory[snakeRow][snakeCol] == '*') {
                            eatenFood++;
                        }
                    } else {
                        isOutSide = true;
                        System.out.println("Game over!");
                        break;
                    }
                    break;
                case "right":
                    snakeCol++;
                    if (isInside(snakeCol, size)) {
                        if (territory[snakeRow][snakeCol] == 'B') {
                            territory[snakeRow][snakeCol] = '.';
                            for (int row = 0; row < size; row++) {
                                for (int col = 0; col < size; col++) {
                                    if (territory[row][col] == 'B') {
                                        snakeRow = row;
                                        snakeCol = col;
                                        territory[snakeRow][snakeCol] = 'S';
                                        break;
                                    }
                                }
                            }
                        } else if (territory[snakeRow][snakeCol] == '*') {
                            eatenFood++;
                        }
                    } else {
                        isOutSide = true;
                        System.out.println("Game over!");
                        break;
                    }
                    break;
                case "up":
                    snakeRow--;
                    if (isInside(snakeRow, size)) {
                        if (territory[snakeRow][snakeCol] == 'B') {
                            territory[snakeRow][snakeCol] = '.';
                            for (int row = 0; row < size; row++) {
                                for (int col = 0; col < size; col++) {
                                    if (territory[row][col] == 'B') {
                                        snakeRow = row;
                                        snakeCol = col;
                                        territory[snakeRow][snakeCol] = 'S';
                                        break;
                                    }
                                }
                            }
                        } else if (territory[snakeRow][snakeCol] == '*') {
                            eatenFood++;
                        }
                    } else {
                        isOutSide = true;
                        System.out.println("Game over!");
                        break;
                    }
                    break;
                case "down":
                    snakeRow++;
                    if (isInside(snakeRow, size)) {
                        if (territory[snakeRow][snakeCol] == 'B') {
                            territory[snakeRow][snakeCol] = '.';
                            for (int row = 0; row < size; row++) {
                                for (int col = 0; col < size; col++) {
                                    if (territory[row][col] == 'B') {
                                        snakeRow = row;
                                        snakeCol = col;
                                        territory[snakeRow][snakeCol] = 'S';
                                        break;
                                    }
                                }
                            }
                        } else if (territory[snakeRow][snakeCol] == '*') {
                            eatenFood++;
                        }
                    } else {
                        isOutSide = true;
                        System.out.println("Game over!");
                        break;
                    }
                    break;
            }
            if (isOutSide) {
                break;
            }
            territory[snakeRow][snakeCol] = 'S';
            if (eatenFood == 10) {
                System.out.println("You won! You fed the snake.");
                break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Food eaten: " + eatenFood);
        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory.length; col++) {
                System.out.print(territory[row][col]);
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
    private static boolean isInside(int number, int size) {
        return number >= 0 && number < size;
    }
}
