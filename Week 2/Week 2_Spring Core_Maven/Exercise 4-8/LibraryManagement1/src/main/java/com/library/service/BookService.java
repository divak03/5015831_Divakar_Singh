package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;
    //Setter Injection
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    //Constructor
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
        System.out.println("This is Constructor Injection");
    }
    
    public void displayBookRepository(){
        System.out.println("The service performed by book repository : "+bookRepository);
    }
}