package StreamsFilesDirectories.Exercise;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String pathOne = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String pathTwo = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";

        PrintWriter writer = new PrintWriter("outputMerge.txt");

        List<String> allLinesFileOne = Files.readAllLines(Path.of(pathOne));
        allLinesFileOne.forEach(writer::println);

        List<String> allLinesFileTwo = Files.readAllLines(Path.of(pathTwo));
        allLinesFileTwo.forEach(writer::println);

        writer.close();
    }
}
