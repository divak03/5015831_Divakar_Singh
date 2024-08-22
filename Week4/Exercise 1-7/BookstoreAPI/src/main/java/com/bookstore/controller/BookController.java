package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "CustomValue");
        return ResponseEntity.ok()
                .headers(headers)
                .body(books);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(book.get());
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Book>> getBookByTitle(@PathVariable String title) {
        List<Book> books = bookService.getTitle(title);
        if (books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author/{author}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable String author) {
        List<Book> books = bookService.getBookByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/price/{price}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Book>> getBookByPrice(@PathVariable Double price) {
        List<Book> books = bookService.getBookByPrice(price);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/isbn/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> insertBook(@RequestBody Book book) {
        Book newBook = bookService.saveBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/books/" + newBook.getId());
        return ResponseEntity.created(URI.create("/books/" + newBook.getId()))
                .headers(headers)
                .body(newBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        if (updatedBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Update-Status", "Book Updated");
        return ResponseEntity.ok()
                .headers(headers)
                .body(updatedBook);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> updateBookPrice(@PathVariable Long id, @RequestBody Double price) {
        Book updatedBook = bookService.updateBookPrice(id, price);
        if (updatedBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Price-Update", "Price Updated");
        return ResponseEntity.ok()
                .headers(headers)
                .body(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        boolean deleted = bookService.deleteBook(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Deletion-Status", "Book deleted successfully!");
        return ResponseEntity.noContent()
                .headers(headers)
                .build();
    }
}
