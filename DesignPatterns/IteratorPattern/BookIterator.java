public class BookIterator {

    private BookCollection collection;
    private int index;

    public BookIterator(BookCollection collection) {
        this.collection = collection;
        this.index = 0;
    }

    // Checks whether another book exists
    public boolean hasNext() {
        return index < collection.getSize();
    }

    // Returns the next book
    public Book next() {

        if (hasNext()) {
            return collection.getBook(index++);
        }

        return null;
    }
}