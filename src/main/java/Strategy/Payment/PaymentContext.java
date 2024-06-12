package Strategy.Payment;


import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;

public class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public PaymentTransaction payOrder(CreditCard card, int amount, String contents) {
        return strategy.payOrder(card, amount, contents);
    }
}

