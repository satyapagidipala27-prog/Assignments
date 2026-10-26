public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        Folder documents = new Folder("documents");
        Folder photos = new Folder("photos");

        File readme = new File("readme.txt");
        File report = new File("report.pdf");
        File notes = new File("notes.txt");
        File holidayPhoto = new File("holiday.jpg");

        // Build the tree: folders can contain either leaf files or composites.
        root.add(readme);
        root.add(documents);
        documents.add(report);
        documents.add(notes);
        documents.add(photos);
        photos.add(holidayPhoto);

        System.out.println("File system:");
        root.display();
        System.out.println("Total files: " + root.countFiles());

        // Manipulate the hierarchy using Folder's composite operations.
        documents.remove(notes);
        photos.add(new File("profile.png"));

        System.out.println("\nAfter removing notes.txt and adding profile.png:");
        root.display();
        System.out.println("Total files: " + root.countFiles());
    }
}
