package StreamsFilesDirectories.Exercise;

import java.io.File;

public class P08_GetFolderSize {
    public static void main(String[] args) {

        String pathFolder = "/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";
        File folder = new File(pathFolder);

        File [] allFilesInFolder = folder.listFiles();

        int folderSize = 0;
        if (allFilesInFolder != null) {
            for (File file : allFilesInFolder) {
                folderSize += file.length();
            }
        }

        System.out.println("Folder size: " + folderSize);
    }
}
