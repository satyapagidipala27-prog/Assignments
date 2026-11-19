public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.processPayment(2000);

        context.setPaymentStrategy(new PayPalPayment());
        context.processPayment(3000);

        context.setPaymentStrategy(new BitcoinPayment());
        context.processPayment(5000);
    }
}
