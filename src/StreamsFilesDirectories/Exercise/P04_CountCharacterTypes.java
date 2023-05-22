package StreamsFilesDirectories.Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P04_CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String pathToFile = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String pathToWrite = "/Users/stilyanov/IdeaProjects/untitled/output.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter(pathToWrite));

        int vowelsCount = 0;
        int punctCount = 0;
        int consonantsCount = 0;

        List<String> allLines = Files.readAllLines(Path.of(pathToFile));

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        Set<Character> punctuations = new HashSet<>();
        punctuations.add('!');
        punctuations.add('?');
        punctuations.add('.');
        punctuations.add(',');

        for (String line : allLines) {
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);

                if (currentSymbol == ' ') {
                    continue;
                }

                if (vowels.contains(currentSymbol)) {
                    vowelsCount++;
                } else if (punctuations.contains(currentSymbol)) {
                    punctCount++;
                } else {
                    consonantsCount++;
                }
            }
        }

        writer.write("Vowels: " + vowelsCount);
        writer.newLine();
        writer.write("Other symbols: " + consonantsCount);
        writer.newLine();
        writer.write("Punctuation: " + punctCount);
        writer.close();
    }
}
