import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;
    
    //Default Constructor of Library class
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    
    //Book management methods
    public void addBook(Book book) {
        books.add(book);
    }
    
    public void removeBook(Book book) {
        books.remove(book);
    }
    
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    
    public List<Book> getAllBooks() {
        return books;
    }
    
    //User management methods
    public void addUser(User user) {
        users.add(user);
    }
    
    public void removeUser(User user) {
        users.remove(user);
    }
    
    public User findUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    
    public List<User> getAllUsers() {
        return users;
    }
    
    //Transaction methods
    public boolean issueBook(String userId, String bookIsbn) {
        User user = findUserById(userId);
        Book book = findBookByIsbn(bookIsbn);
        
        if (user == null || book == null || !book.isAvailable()) {
            return false;
        }
        
        book.setAvailable(false);
        user.borrowBook(book);
        return true;
    }
    
    public boolean returnBook(String userId, String bookIsbn) {
        User user = findUserById(userId);
        Book book = findBookByIsbn(bookIsbn);
        
        if (user == null || book == null || book.isAvailable()) {
            return false;
        }
        
        if (!user.getBorrowedBooks().contains(book)) {
            return false;
        }
        
        book.setAvailable(true);
        user.returnBook(book);
        return true;
    }
}