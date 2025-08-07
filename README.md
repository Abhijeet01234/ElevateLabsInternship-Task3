# Elevate Labs Internship - Task 3: Library Management System (Using OOP)
A Java-based Library Management System developed using Object-Oriented Programming principles.

## Key Features

- **Built with Java 21**
- **Book Management**:
  - Add new books to the library
  - View all available books
  - Check book availability status

- **User Management**:
  - Register new users
  - View all registered users

- **Transaction Management**:
  - Issue books to users
  - Return books
  - Track borrowed books

## How to Use

### Requirements
- Java 21 JDK ([Download here](https://www.oracle.com/java/technologies/downloads/))
  
## Class Diagram

```mermaid
classDiagram
    class Book {
        -String title
        -String author
        -String isbn
        -boolean isAvailable
        +getTitle()
        +getAuthor()
        +getIsbn()
        +isAvailable()
        +setAvailable()
    }

    class User {
        -String name
        -String id
        -List<Book> borrowedBooks
        +getName()
        +getId()
        +getBorrowedBooks()
        +borrowBook()
        +returnBook()
    }

    class Library {
        -List<Book> books
        -List<User> users
        +addBook()
        +removeBook()
        +findBookByIsbn()
        +addUser()
        +removeUser()
        +findUserById()
        +issueBook()
        +returnBook()
    }

    Library "1" *-- "0..*" Book
    Library "1" *-- "0..*" User
    User "0..*" --> "0..*" Book
