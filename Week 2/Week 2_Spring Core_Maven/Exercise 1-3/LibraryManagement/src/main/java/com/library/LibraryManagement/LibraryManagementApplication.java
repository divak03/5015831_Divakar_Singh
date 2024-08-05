package com.library.LibraryManagement;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring context
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        // Test the configuration
        bookService.performService();
        
        context.close();
    }
}
