package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P02_WriteToFile {
    public static void main(String[] args) throws IOException {
        String pathRead = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathWrite = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources/02.WriteToFileOutput.txt";

        FileInputStream inputStream = new FileInputStream(pathRead);
        FileOutputStream outputStream = new FileOutputStream(pathWrite);

        int currentByte = inputStream.read();
        while (currentByte >= 0) {
            char currentSymbol = (char) currentByte;
            if (currentSymbol != ',' && currentSymbol != '.' && currentSymbol != '!' && currentSymbol != '?') {
                outputStream.write(currentSymbol);
            }
            currentByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
