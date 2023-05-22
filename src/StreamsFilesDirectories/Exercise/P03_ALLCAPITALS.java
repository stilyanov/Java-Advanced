package StreamsFilesDirectories.Exercise;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P03_ALLCAPITALS {
    public static void main(String[] args) throws IOException {

        String pathToFile = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        List<String> allLines = Files.readAllLines(Path.of(pathToFile));

        for (String line : allLines) {
            writer.write(line.toUpperCase());
            writer.newLine();
        }
        writer.close();
    }
}
