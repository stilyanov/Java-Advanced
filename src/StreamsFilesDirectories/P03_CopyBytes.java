package StreamsFilesDirectories;

import java.io.*;

public class P03_CopyBytes {
    public static void main(String[] args) throws IOException {
        String pathRead = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathWrite = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources/03.CopyBytesOutput.txt";

        FileInputStream inputStream = new FileInputStream(pathRead);
        FileOutputStream outputStream = new FileOutputStream(pathWrite);

        int oneByte = inputStream.read();
        while (oneByte >= 0) {
            if (oneByte == 32 || oneByte == 10) {
                outputStream.write(oneByte);
            } else {
                String digits = String.valueOf(oneByte);
                for (int i = 0; i < digits.length(); i++) {
                    outputStream.write(digits.charAt(i));
                }
            }
            oneByte = inputStream.read();
        }
    }
}
