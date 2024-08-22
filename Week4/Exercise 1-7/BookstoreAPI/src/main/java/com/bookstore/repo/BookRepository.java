package com.bookstore.repo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query(name = "Book.findByTitle")
    Optional<Book> findByTitle(@Param("title") String title);
    @Query("SELECT b FROM Book b WHERE b.author=:author")
    List<Book> findByAuthor(@Param("author") String author);
    @Query("select b from Book b where b.price=:price")
    List<Book> findByPrice(Double price);
    @Query("select b from Book b where b.isbn=:isbn")
    Book findByIsbn(String isbn);
}