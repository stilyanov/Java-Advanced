package StreamsFilesDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P02_SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        // НАЧИН 1:
        /*List<String> allLines = Files.readAllLines(Path.of(path));

        long sum = 0;

        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
        }
        System.out.println(sum);*/

        // НАЧИН 2:

        long sum = 0;

        byte [] allBytes = Files.readAllBytes(Path.of(path));
        for (byte ascii : allBytes) {
            if (ascii != 10 && ascii != 13) {
                sum += ascii;
            }
        }
        System.out.println(sum);
    }
}
