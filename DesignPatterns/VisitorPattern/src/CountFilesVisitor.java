public class CountFilesVisitor implements FileSystemVisitor {
    private int count;

    @Override
    public void visit(File file) {
        count++;
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public int getCount() {
        return count;
    }
}
