/** Leaf in the file system tree. */
public class File implements FileSystemComponent {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        display(0);
    }

    @Override
    public void display(int indentation) {
        System.out.println("  ".repeat(indentation) + "File: " + name);
    }

    @Override
    public int countFiles() {
        return 1;
    }
}
