package com.library.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.LibraryManagement1.service.*.*(..))")
    public void logBeforeMethod() {
        System.out.println("Loging before method execution");
    }

    @After("execution(* com.library.LibraryManagement1.service.*.*(..))")
    public void logAfterMethod() {
        System.out.println("Loging after method execution");
    }
}
