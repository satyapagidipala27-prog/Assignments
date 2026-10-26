
import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {

    private String name;
    private List<FileSystemComponent> children;

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void display() {
        System.out.println("Folder: " + name);

        for (FileSystemComponent child : children) {
            child.display();
        }
    }

    @Override
    public int countFiles() {
        int total = 0;

        for (FileSystemComponent child : children) {
            total += child.countFiles();
        }

        return total;
    }
}
