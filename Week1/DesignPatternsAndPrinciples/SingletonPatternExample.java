package DesignPatternsAndPrinciples;


class Logger {
 
 private static Logger instance;

 // Private constructor 
 private Logger() {
     // Initialize the logger
 }


 public static Logger getInstance() {
     if (instance == null) {
         synchronized (Logger.class) {
             if (instance == null) {
                 instance = new Logger();
             }
         }
     }
     return instance;
 }


 public void log(String message) {
     System.out.println("Log: " + message);
 }
}


public class SingletonPatternExample {
 public static void main(String[] args) {
     
     Logger logger1 = Logger.getInstance();
     Logger logger2 = Logger.getInstance();

     
     logger1.log("Singleton pattern example started.");
     logger2.log("This should use the same logger instance.");

     
     if (logger1 == logger2) {
         System.out.println("Both logger instances are the same.");
     } else {
         System.out.println("Logger instances are different.");
     }
 }
}

