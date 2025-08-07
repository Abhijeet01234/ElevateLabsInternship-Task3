import java.util.*;

public class LibraryManagementSystem {
    private static Library library = new Library();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        showMenu();
    }
    
    private static void showMenu() {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("------------------------------");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Display All Users");
            System.out.println("7. Exit");
            System.out.println("------------------------------");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            System.out.println("------------------------------");
            sc.nextLine(); //It will consume newline
            
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    displayAllBooks();
                    break;
                case 6:
                    displayAllUsers();
                    break;
                case 7:
                    System.out.println("Exiting system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    //Mehtod to add a new book in system
    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter book author: ");
        String author = sc.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = sc.nextLine();
        
        Book book = new Book(title, author, isbn); //creating Book object
        library.addBook(book);
        System.out.println("Book added successfully!");
    }
    
    //Method to add User in the system
    private static void addUser() {
        System.out.print("Enter user name: ");
        String name = sc.nextLine();
        System.out.print("Enter user ID: ");
        String id = sc.nextLine();
        
        User user = new User(name, id);
        library.addUser(user);
        System.out.println("User added successfully!");
    }
    
    //Method to issue the book to an User 
    private static void issueBook() {
        System.out.print("Enter user ID: ");
        String userId = sc.nextLine();
        System.out.print("Enter book ISBN: ");
        String bookIsbn = sc.nextLine();
        
        if (library.issueBook(userId, bookIsbn)) {
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Failed to issue book. Please check user ID, book ISBN, or book availability.");
        }
    }
    
    //Method to return a book from an User
    private static void returnBook() {
        System.out.print("Enter user ID: ");
        String userId = sc.nextLine();
        System.out.print("Enter book ISBN: ");
        String bookIsbn = sc.nextLine();
        
        if (library.returnBook(userId, bookIsbn)) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Failed to return book. Please check user ID, book ISBN, or if the book was borrowed by this user.");
        }
    }
    
    //Method to display all books available in system
    private static void displayAllBooks() {
        List<Book> books = library.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\nList of all books:");
            System.out.println("------------------------------");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    
    //Method to display all Users present in system
    private static void displayAllUsers() {
        List<User> users = library.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users registered.");
        } else {
            System.out.println("\nList of all users:");
            System.out.println("------------------------------");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}