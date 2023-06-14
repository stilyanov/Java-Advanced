package ExamPreparation;

import java.util.Scanner;

public class P02_Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] territory = new char[size][size];

        int beeRow = -1;
        int beeCol = -1;

        for (int row = 0; row < size; row++) {
            territory[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                if (territory[row][col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }
        int pollinatedFlowers = 0;

        boolean isOutSide = false;

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            territory[beeRow][beeCol] = '.';
            switch (command) {
                case "left":
                    beeCol--;
                    if (isInside(beeCol, size)) {
                        if (territory[beeRow][beeCol] == 'f') {
                            pollinatedFlowers++;
                        } else if (territory[beeRow][beeCol] == 'O') {
                            territory[beeRow][beeCol] = '.';
                            beeCol--;
                            if (isInside(beeCol, size)) {
                                if (territory[beeRow][beeCol] == 'f') {
                                    territory[beeRow][beeCol] = '.';
                                    pollinatedFlowers++;
                                }
                            }
                        }
                    } else {
                        isOutSide = true;
                        break;
                    }
                    break;
                case "right":
                    beeCol++;
                    if (isInside(beeCol, size)) {
                        if (territory[beeRow][beeCol] == 'f') {
                            pollinatedFlowers++;
                        } else if (territory[beeRow][beeCol] == 'O') {
                            territory[beeRow][beeCol] = '.';
                            beeCol++;
                            if (isInside(beeCol, size)) {
                                if (territory[beeRow][beeCol] == 'f') {
                                    territory[beeRow][beeCol] = '.';
                                    pollinatedFlowers++;
                                }
                            }
                        }
                    } else {
                        isOutSide = true;
                        break;
                    }
                    break;
                case "up":
                    beeRow--;
                    if (isInside(beeRow, size)) {
                        if (territory[beeRow][beeCol] == 'f') {
                            pollinatedFlowers++;
                        } else if (territory[beeRow][beeCol] == 'O') {
                            territory[beeRow][beeCol] = '.';
                            beeRow--;
                            if (isInside(beeRow, size)) {
                                if (territory[beeRow][beeCol] == 'f') {
                                    territory[beeRow][beeCol] = '.';
                                    pollinatedFlowers++;
                                }
                            }
                        }
                    } else {
                        isOutSide = true;
                        break;
                    }
                    break;
                case "down":
                    beeRow++;
                    if (isInside(beeRow, size)) {
                        if (territory[beeRow][beeCol] == 'f') {
                            pollinatedFlowers++;
                        } else if (territory[beeRow][beeCol] == 'O') {
                            territory[beeRow][beeCol] = '.';
                            beeRow++;
                            if (isInside(beeRow, size)) {
                                if (territory[beeRow][beeCol] == 'f') {
                                    territory[beeRow][beeCol] = '.';
                                    pollinatedFlowers++;
                                }
                            }
                        }
                    } else {
                        isOutSide = true;
                        break;
                    }
                    break;
            }
            if (!isOutSide) {
                territory[beeRow][beeCol] = 'B';
                command = scanner.nextLine();
            } else {
                System.out.println("The bee got lost!");
                break;
            }
        }
        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(territory[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isInside(int number, int size) {
        return number >= 0 && number < size;
    }
}
