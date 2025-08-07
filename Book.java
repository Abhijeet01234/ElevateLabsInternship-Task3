public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    
    //Generating Parameterised Constructor of Book class
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }
    
    //Generating Getters and setters
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    //Generating toString Method for output
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + 
               ", Available: " + (isAvailable ? "Yes" : "No");
    }
}