public class Main {
    public static void main(String[] args) {
        Document document = new Document();
        TextEditor editor = new TextEditor();

        editor.executeCommand(new TypeCommand(document, "Hello"));
        System.out.println(document.getContent());

        editor.executeCommand(new TypeCommand(document, " World"));
        System.out.println(document.getContent());

        editor.undo();
        System.out.println("After Undo: " + document.getContent());

        editor.undo();
        System.out.println("After Undo: " + document.getContent());

        editor.redo();
        System.out.println("After Redo: " + document.getContent());

        editor.redo();
        System.out.println("After Redo: " + document.getContent());
    }
}
