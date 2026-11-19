public class Main {

    public static void main(String[] args) {

        // Create book collection
        BookCollection library = new BookCollection();

        // Add books
        library.addBook(
                new Book("Clean Code", "Robert C. Martin")
        );

        library.addBook(
                new Book("Effective Java", "Joshua Bloch")
        );

        library.addBook(
                new Book("Head First Java", "Kathy Sierra")
        );

        library.addBook(
                new Book("The Pragmatic Programmer", "Andrew Hunt")
        );

        // Create iterator
        BookIterator iterator = library.createIterator();

        // Iterate through books
        System.out.println("Library Books");
        System.out.println("-------------------------");

        while (iterator.hasNext()) {

            Book book = iterator.next();

            System.out.println(book);
        }
    }
}