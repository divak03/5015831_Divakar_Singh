package com.bookstore.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookstore.entity.Book;
import com.bookstore.repo.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepo;

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }
    public Optional<Book> getBookById(Long id){
        return bookRepo.findById(id);
    }
    public Optional<Book> getBookByTitle(String title){
        return bookRepo.findByTitle(title);
    }
    public List<Book> getBookByAuthor(String author){
        return bookRepo.findByAuthor(author);
    }
    public List<Book> getBookByPrice(Double price){
        return bookRepo.findByPrice(price);
    }
    public Book getBookByIsbn(String isbn){
        return bookRepo.findByIsbn(isbn);
    }
    public Book saveBook(Book book){
        return bookRepo.save(book);
    }
    public Book updateBook(Long id, Book updatedBook){
        Optional<Book> existingBook=bookRepo.findById(id);
        if(existingBook.isPresent()){
            Book book=existingBook.get();
            book.setAuthor(updatedBook.getAuthor());
            book.setIsbn(updatedBook.getIsbn());
            book.setTitle(updatedBook.getTitle());
            book.setPrice(updatedBook.getPrice());
            return bookRepo.save(book);
        }
        else{
            throw new RuntimeException("Book not found");
        }
    }
    public Book updateBookPrice(Long id, Double price) {
        Optional<Book> existing=bookRepo.findById(id);
        if(existing.isPresent()){
            Book book=existing.get();
            book.setPrice(price);
            return bookRepo.save(book);
        }
        else{
            throw new RuntimeException("Book not found");
        }
    }
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}