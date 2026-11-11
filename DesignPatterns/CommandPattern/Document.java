public class Document {

    private StringBuilder content = new StringBuilder();

    public void type(String text) {
        content.append(text);
    }

    public void delete(int length) {
        content.delete(
                content.length() - length,
                content.length()
        );
    }

    public String getContent() {
        return content.toString();
    }
}