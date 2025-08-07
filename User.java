import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String id;
    private List<Book> borrowedBooks;
    
    //Generating Parameterised Constructor
    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }
    
    //Generating Getters Methods
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }
    
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    
    //Creating Methods to manage borrowed books
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
    
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
    
    //Generating toString Method
    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Books Borrowed: " + borrowedBooks.size();
    }
}