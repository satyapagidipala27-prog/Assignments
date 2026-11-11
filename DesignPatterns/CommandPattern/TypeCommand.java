public class TypeCommand implements Command {

    private Document document;
    private String text;

    public TypeCommand(Document document, String text) {
        this.document = document;
        this.text = text;
    }

    @Override
    public void execute() {
        document.type(text);
    }

    @Override
    public void undo() {
        document.delete(text.length());
    }
}