public class Main {

    public static void main(String[] args) {
        Directory root = new Directory("Root");
        Directory documents = new Directory("Documents");

        root.add(new File("File1.txt", 10));
        root.add(documents);
        documents.add(new File("File2.pdf", 20));
        documents.add(new File("File3.docx", 30));

        System.out.println("--- File Structure ---");
        root.accept(new PrintStructureVisitor());

        System.out.println("\n--- Total Size ---");
        CalculateTotalSizeVisitor sizeVisitor = new CalculateTotalSizeVisitor();
        root.accept(sizeVisitor);
        System.out.println(sizeVisitor.getTotalSize() + " KB");

        System.out.println("\n--- Find File ---");
        FindFileVisitor findVisitor = new FindFileVisitor("File2.pdf");
        root.accept(findVisitor);
        if (!findVisitor.isFound()) {
            System.out.println("File not found");
        }
    }
}
