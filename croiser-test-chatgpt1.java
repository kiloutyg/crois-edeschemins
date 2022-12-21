import java.io.File;

public class DirectoryTree {

    public static void main(String[] args) {
        // Set the root directory
        File root = new File("/home");

        // Print the directory tree
        printDirectoryTree(root, 0);
    }

    private static void printDirectoryTree(File file, int indent) {
        // Print the file or directory name
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        System.out.println(file.getName());

        // If the file is a directory, print its contents
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printDirectoryTree(f, indent + 2);
                }
            }
        }
    }
}
