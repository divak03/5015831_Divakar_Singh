package com.library.repository;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public BookRepository(){
        System.out.println("This is a Book Repository ");
    }
}