package StreamsFilesDirectories.Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05_LineNumbers {
    public static void main(String[] args) throws IOException {

        String pathToRead = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        String pathToWrite = "/Users/stilyanov/IdeaProjects/untitled/output.txt";

        PrintWriter writer = new PrintWriter(pathToWrite);

        List<String> allLines = Files.readAllLines(Path.of(pathToRead));

        int lineNumber = 1;
        for (String line : allLines) {
            writer.println(lineNumber + ". " + line);
            lineNumber++;
        }
        writer.close();
    }
}
