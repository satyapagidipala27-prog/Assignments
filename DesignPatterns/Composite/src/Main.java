
public class Main {

    public static void main(String[] args) {

        // Create folders
        Folder root = new Folder("Root");
        Folder documents = new Folder("Documents");
        Folder projects = new Folder("Projects");
        Folder images = new Folder("Images");

        // Create files
        File resume = new File("Resume.pdf");
        File notes = new File("Notes.txt");
        File javaFile = new File("Main.java");
        File readme = new File("README.txt");
        File photo = new File("photo.jpg");

        // Add files to Documents
        documents.add(resume);
        documents.add(notes);

        // Add files to Projects
        projects.add(javaFile);
        projects.add(readme);

        // Add file to Images
        images.add(photo);

        // Add nested folders to Documents
        documents.add(projects);
        documents.add(images);

        // Add Documents to Root
        root.add(documents);

        // Display the entire hierarchy
        System.out.println("=== File System Hierarchy ===");
        root.display();

        // Count all files
        System.out.println("\nTotal files: " + root.countFiles());
    }
}
