import java.util.ArrayList;
import java.util.List;

/** Composite that contains files and/or other folders. */
public class Folder implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("A folder cannot contain a null component");
        }
        children.add(component);
    }

    public boolean remove(FileSystemComponent component) {
        return children.remove(component);
    }

    @Override
    public void display() {
        display(0);
    }

    @Override
    public void display(int indentation) {
        System.out.println("  ".repeat(indentation) + "Folder: " + name);
        for (FileSystemComponent child : children) {
            child.display(indentation + 1);
        }
    }

    @Override
    public int countFiles() {
        int count = 0;
        for (FileSystemComponent child : children) {
            count += child.countFiles();
        }
        return count;
    }
}
