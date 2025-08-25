import com.example.librarybooklendingsysten.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {

    private LibraryService library;
    private User user;

    @BeforeEach
    void setup() {
        library = new LibraryService(Arrays.asList(
                new Book("1984", "Orwell", "Dystopian"),
                new Book("Hobbit", "Tolkien", "Fantasy"),
                new Book("Mockingbird", "Harper", "Classic")
        ));
        user = new User("TestUser");
    }

    @Test
    void testSuccessfulBorrow() {
        library.borrowBook(user, "1984");
        assertEquals(1, user.getBorrowedBooks().size());
    }

    @Test
    void testBorrowNonExistentBook() {
        assertThrows(BookUnavailableException.class, () -> library.borrowBook(user, "Unknown Book"));
    }

    @Test
    void testBookLimitExceeded() {
        library.borrowBook(user, "1984");
        library.borrowBook(user, "Hobbit");
        library.borrowBook(user, "Mockingbird");
        assertThrows(BookLimitExceededException.class, () -> library.borrowBook(user, "Hobbit"));
    }

    @Test
    void testReturnBook() {
        library.borrowBook(user, "1984");
        library.returnBook(user, "1984");
        assertEquals(0, user.getBorrowedBooks().size());
    }

    @Test
    void testFilterByAuthor() {
        assertEquals(1, library.filterBooksByAuthor("Tolkien").size());
    }

    @Test
    void testFilterByGenre() {
        assertEquals(1, library.filterBooksByGenre("Dystopian").size());
    }
}
