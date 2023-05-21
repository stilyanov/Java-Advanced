package StreamsFilesDirectories;

import java.io.File;
import java.util.ArrayDeque;

public class P08_NestedFolders {
    public static void main(String[] args) {

        File root = new File("/Users/stilyanov/IdeaProjects/untitled/src/StreamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams");

        ArrayDeque<File> dirs = new ArrayDeque<>();

        dirs.offer(root);

        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File file : nestedFiles) {
                if (file.isDirectory()) {
                    dirs.offer(file);
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.printf("%d folders%n", count);
    }
}
