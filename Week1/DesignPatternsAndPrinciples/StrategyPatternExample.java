package DesignPatternsAndPrinciples;

interface PaymentStrategy {
    void pay(double amount);
}


class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}


class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}


class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("No payment strategy set.");
        }
    }
}


public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

       
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432", "Vijay Kumar"));
        context.pay(100.0);

        
        context.setPaymentStrategy(new PayPalPayment("vijaykumar@example.com"));
        context.pay(150.0);
    }
}
