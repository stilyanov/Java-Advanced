package StreamsFilesDirectories;

import java.io.*;
import java.util.Scanner;

public class P04_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String pathRead = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        FileInputStream inputStream = new FileInputStream(pathRead);
        Scanner scanner = new Scanner(inputStream);

        String pathWrite = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources/04.ExtractIntegersOutput.txt";
        FileOutputStream outputStream = new FileOutputStream (pathWrite);
        PrintWriter writer = new PrintWriter(outputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.println(number);
            }
            scanner.next();
        }
        writer.close();
    }
}
