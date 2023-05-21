package StreamsFilesDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class P06_SortLines {
    public static void main(String[] args) throws IOException {
        Path pathRead = Paths.get("/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
        Path pathWrite = Paths.get("/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources/06.SortLinesOutput.txt");

        List<String> lines = Files.readAllLines(pathRead);
        Collections.sort(lines);
        Files.write(pathWrite, lines);
    }
}
