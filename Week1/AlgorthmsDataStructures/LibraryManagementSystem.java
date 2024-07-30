package AlgorthmsDataStructures;

import java.util.Arrays;
import java.util.Scanner;

class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book [ID=" + bookId + ", Title=" + title + ", Author=" + author + "]";
    }
}

class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "Harry Potter", "F. Scott Fitzgerald"),
            new Book("B002", "Gulliven Tunnel", "Harper Lee"),
            new Book("B003", "1984", "George Orwell"),
            new Book("B004", "Pride and Prejudice", "Jane Austen"),
            new Book("B005", "Alice Wonderland", "J.D. Salinger")
        };

        // Sorting books by title for binary search
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        Library library = new Library(books);
        Scanner scanner = new Scanner(System.in);
        boolean continueSearching = true;

        while (continueSearching) {
            System.out.println("\nLibrary Management System - Search Menu");
            System.out.println("1. Linear Search by Title");
            System.out.println("2. Binary Search by Title");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Linear Search
                    System.out.print("Enter book title for linear search: ");
                    String linearTitle = scanner.nextLine();
                    Book linearResult = library.linearSearchByTitle(linearTitle);
                    System.out.println("Linear Search Result: " + (linearResult != null ? linearResult : "Book not found"));
                    break;
                case 2:
                    // Binary Search
                    System.out.print("Enter book title for binary search: ");
                    String binaryTitle = scanner.nextLine();
                    Book binaryResult = library.binarySearchByTitle(binaryTitle);
                    System.out.println("Binary Search Result: " + (binaryResult != null ? binaryResult : "Book not found"));
                    break;
                case 3:
                    continueSearching = false;
                    System.out.println("Exiting the library management system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
