public class FindFileVisitor implements FileSystemVisitor {
    private final String targetName;
    private boolean found;

    public FindFileVisitor(String targetName) {
        this.targetName = targetName;
    }

    @Override
    public void visit(File file) {
        if (file.getName().equals(targetName)) {
            System.out.println("Found: " + file.getName());
            found = true;
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public boolean isFound() {
        return found;
    }
}
