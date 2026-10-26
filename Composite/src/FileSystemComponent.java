/** Common operations supported by files and folders. */
public interface FileSystemComponent {
    void display();

    /** Displays this component at the requested nesting level. */
    void display(int indentation);

    /** Returns the number of files in this component and its descendants. */
    int countFiles();
}
