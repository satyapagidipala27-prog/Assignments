import java.util.ArrayList;
import java.util.List;

public class BookCollection {

    private List<Book> books;

    public BookCollection() {
        books = new ArrayList<>();
    }

    // Add books
    public void addBook(Book book) {
        books.add(book);
    }

    // Returns the number of books
    public int getSize() {
        return books.size();
    }

    // Internal access used by BookIterator
    Book getBook(int index) {
        return books.get(index);
    }

    // Creates and returns an iterator
    public BookIterator createIterator() {
        return new BookIterator(this);
    }
}