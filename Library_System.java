import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Library_System {
    public static void main(String[] args) {
        Library library = new Library();
        LibraryController controller = new LibraryController(library);

        System.out.println("Use case: Borrow");
        controller.handleBorrowRequest("Student Alice", "Universe in a Nutshell");
        System.out.println("---");
        System.out.println("Try to borrow it again");
        controller.handleBorrowRequest("Student Bob", "Universe in a Nutshell");
        System.out.println("---");
        System.out.println("Borrow another book.");
        controller.handleBorrowRequest("Student Alice", "Design Patterns");
    }
}

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markAsBorrowed() {
        this.isAvailable = false;
    }

    public void markAsReturned() {
        this.isAvailable = true;
    }

    @Override
    public String toString() {
       
        return "'" + title + "' by " + author;
    }
}

class BorrowTransaction {
    private String studentName;
    private Book book;
    private Date borrowDate;

    public BorrowTransaction(String studentName, Book book) {
        this.studentName = studentName;
        this.book = book;
        this.borrowDate = new Date();
    }

    @Override
    public String toString() {
        
        return "Transaction: " + studentName + " Borrowed " + book.getTitle() + " on " + borrowDate;
    } 
}

class Library {
    private List<Book> allBooks = new ArrayList<>();
    private List<BorrowTransaction> borrowedRecords = new ArrayList<>();

    public Library() {
        allBooks.add(new Book("Design Patterns", "Erich Gamma"));
        allBooks.add(new Book("Universe in a Nutshell", "Stephen Hawking"));
    }

    public Book findAvailableBook(String title) {
        for (Book book : allBooks) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }

    public BorrowTransaction createBorrowTransaction(String studentName, Book book) {
        book.markAsBorrowed();
        BorrowTransaction transaction = new BorrowTransaction(studentName, book);
        borrowedRecords.add(transaction);
       
        System.out.println("  Library: Book '" + book.getTitle() + "' mark as borrowed.");
        System.out.println("  Library: New transaction created.");
        return transaction;
    }

    public int getTotalBorrowedBooks() {
        return borrowedRecords.size();
    }
}

class LibraryController {
    private Library library;

    public LibraryController(Library library) {
        this.library = library;
    }

    public void handleBorrowRequest(String studentName, String bookTitle) {
        
        System.out.println("Controller: Received request for '" + bookTitle + "' from " + studentName);

        Book book = library.findAvailableBook(bookTitle);
        if (book != null) {
            library.createBorrowTransaction(studentName, book);
            System.out.println("Controller: Borrow request Successful.");
        } else {
            
            System.out.println("Controller: Borrow request FAILED. Book not available.");
        }
        System.out.println("Controller: Total books now borrowed: " + library.getTotalBorrowedBooks());
    }
}