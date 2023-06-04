package ExamPreparation;

import java.util.Scanner;

public class P02_TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hazelnuts = 0;
        boolean isTrap = false;

        int size = Integer.parseInt(scanner.nextLine());
        String [] directions = scanner.nextLine().split(", ");

        char [][] field = createMatrix(size, scanner);

        int squirrelRow = -1;
        int squirrelCol = -1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (field[row][col] == 's') {
                    squirrelRow = row;
                    squirrelCol = col;
                }
            }
        }

        for (String direction : directions) {
            //direction -> "left", "right", "up", "down"
            if (direction.equals("left")) {
                if (isInside(squirrelCol - 1, size)) {
                    field[squirrelRow][squirrelCol] = '*';
                    squirrelCol -= 1;
                    if (field[squirrelRow][squirrelCol] == 't') {
                        isTrap = true;
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        break;
                    } else if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnuts++;
                        field[squirrelRow][squirrelCol] = 's';
                    }
                } else {
                    isTrap = true;
                    System.out.println("The squirrel is out of the field.");
                    break;
                }
            } else if (direction.equals("right")) {
                if (isInside(squirrelCol + 1, size)) {
                    squirrelCol += 1;
                    if (field[squirrelRow][squirrelCol] == 't') {
                        isTrap = true;
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        break;
                    } else if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnuts++;
                        field[squirrelRow][squirrelCol] = 's';
                    }
                } else {
                    isTrap = true;
                    System.out.println("The squirrel is out of the field.");
                    break;
                }
            } else if (direction.equals("up")) {
                if (isInside(squirrelRow - 1, size)) {
                    squirrelRow -= 1;
                    if (field[squirrelRow][squirrelCol] == 't') {
                        isTrap = true;
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        break;
                    } else if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnuts++;
                        field[squirrelRow][squirrelCol] = 's';
                    }
                } else {
                    isTrap = true;
                    System.out.println("The squirrel is out of the field.");
                    break;
                }
            } else if (direction.equals("down")) {
                if (isInside(squirrelRow + 1, size)) {
                    squirrelRow += 1;
                    if (field[squirrelRow][squirrelCol] == 't') {
                        isTrap = true;
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        break;
                    } else if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnuts++;
                        field[squirrelRow][squirrelCol] = 's';
                    }
                } else {
                    isTrap = true;
                    System.out.println("The squirrel is out of the field.");
                    break;
                }
            }

            if (hazelnuts == 3) {
                System.out.println("Good job! You have collected all hazelnuts!");
                break;
            }
        }

        if (hazelnuts >= 3 || isTrap) {
            System.out.println("Hazelnuts collected: " + hazelnuts);
        } else if (!isTrap){
            System.out.println("There are more hazelnuts to collect.");
            System.out.println("Hazelnuts collected: " + hazelnuts);
        }


    }

    private static char[][] createMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            char[] rowData = scanner.nextLine().toCharArray();

            for (int col = 0; col < size; col++) {
                char currentSymbol = rowData[col];
                matrix[row][col] = currentSymbol;
            }
        }

        return matrix;
    }

    private static boolean isInside (int number, int size) {
        return number >= 0 && number < size;
    }
}