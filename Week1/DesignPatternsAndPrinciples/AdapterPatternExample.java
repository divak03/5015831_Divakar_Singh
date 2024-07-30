package DesignPatternsAndPrinciples;


interface PaymentProcessor {
 void processPayment(double amount);
}


class PayPalGateway {
 public void sendPayment(double amount) {
     System.out.println("Processing payment through PayPal: $" + amount);
 }
}


class StripeGateway {
 public void makePayment(double amount) {
     System.out.println("Processing payment through Stripe: $" + amount);
 }
}


class SquareGateway {
 public void doPayment(double amount) {
     System.out.println("Processing payment through Square: $" + amount);
 }
}


class PayPalAdapter implements PaymentProcessor {
 private PayPalGateway paypal;

 public PayPalAdapter(PayPalGateway paypal) {
     this.paypal = paypal;
 }

 @Override
 public void processPayment(double amount) {
     paypal.sendPayment(amount);
 }
}


class StripeAdapter implements PaymentProcessor {
 private StripeGateway stripe;

 public StripeAdapter(StripeGateway stripe) {
     this.stripe = stripe;
 }

 @Override
 public void processPayment(double amount) {
     stripe.makePayment(amount);
 }
}


class SquareAdapter implements PaymentProcessor {
 private SquareGateway square;

 public SquareAdapter(SquareGateway square) {
     this.square = square;
 }

 @Override
 public void processPayment(double amount) {
     square.doPayment(amount);
 }
}


public class AdapterPatternExample {
 public static void main(String[] args) {
    
     PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
     paypalProcessor.processPayment(100.0);

   
     PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
     stripeProcessor.processPayment(200.0);

    
     PaymentProcessor squareProcessor = new SquareAdapter(new SquareGateway());
     squareProcessor.processPayment(300.0);
 }
}









