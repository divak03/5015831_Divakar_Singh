package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    //Exercise 2 
    
    // Setter method
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // Service method
    public void performService() {
        System.out.println("Performing service with the help of book repository method");
        bookRepository.performRepositoryOperation();
    }
}
