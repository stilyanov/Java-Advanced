package StreamsFilesDirectories.Exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P01_SumLines {
    public static void main(String[] args) throws IOException {

        String path = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        List<String> allLines = Files.readAllLines(Path.of(path));

        for (String line : allLines) {
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
        }
    }
}
