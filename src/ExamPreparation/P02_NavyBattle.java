package ExamPreparation;

import java.util.Scanner;

public class P02_NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[size][size];

        int subMarineRow = -1;
        int subMarineCol = -1;

        for (int row = 0; row < size; row++) {
            field[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                if (field[row][col] == 'S') {
                    subMarineRow = row;
                    subMarineCol = col;
                }
            }
        }

        int mines = 0;
        int battleCruiser = 0;

        String direction = scanner.nextLine();
        while (true) {
            switch (direction) {
                case "up":
                    if (isInside(subMarineRow - 1, size)) {
                        field[subMarineRow][subMarineCol] = '-';
                        subMarineRow--;
                        if (field[subMarineRow][subMarineCol] == '-') {
                            field[subMarineRow][subMarineCol] = 'S';
                            direction = scanner.nextLine();
                            continue;
                        } else if (field[subMarineRow][subMarineCol] == '*') {
                            mines++;
                        } else if (field[subMarineRow][subMarineCol] == 'C') {
                            battleCruiser++;
                        }
                    }
                    break;
                case "down":
                    if (isInside(subMarineRow + 1, size)) {
                        field[subMarineRow][subMarineCol] = '-';
                        subMarineRow++;
                        if (field[subMarineRow][subMarineCol] == '-') {
                            field[subMarineRow][subMarineCol] = 'S';
                            direction = scanner.nextLine();
                            continue;
                        } else if (field[subMarineRow][subMarineCol] == '*') {
                            mines++;
                        } else if (field[subMarineRow][subMarineCol] == 'C') {
                            battleCruiser++;
                        }
                    }

                    break;
                case "left":
                    if (isInside(subMarineCol - 1, size)) {
                        field[subMarineRow][subMarineCol] = '-';
                        subMarineCol--;
                        if (field[subMarineRow][subMarineCol] == '-') {
                            field[subMarineRow][subMarineCol] = 'S';
                            direction = scanner.nextLine();
                            continue;
                        } else if (field[subMarineRow][subMarineCol] == '*') {
                            mines++;
                        } else if (field[subMarineRow][subMarineCol] == 'C') {
                            battleCruiser++;
                        }
                    }
                    break;
                case "right":
                    if (isInside(subMarineCol + 1, size)) {
                        field[subMarineRow][subMarineCol] = '-';
                        subMarineCol++;
                        if (field[subMarineRow][subMarineCol] == '-') {
                            field[subMarineRow][subMarineCol] = 'S';
                            direction = scanner.nextLine();
                            continue;
                        } else if (field[subMarineRow][subMarineCol] == '*') {
                            mines++;
                        } else if (field[subMarineRow][subMarineCol] == 'C') {
                            battleCruiser++;
                        }
                    }
                    break;
            }
            field[subMarineRow][subMarineCol] = 'S';
            int currentRow = subMarineRow;
            int currentCol = subMarineCol;

            if (mines == 3) {
                System.out.println("Mission failed, U-9 disappeared! Last known coordinates [" + currentRow + ", " + currentCol + "]!");
                break;
            }
            if (battleCruiser == 3) {
                System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                break;
            }

            direction = scanner.nextLine();
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isInside(int number, int size) {
        return number >= 0 && number < size;
    }
}
