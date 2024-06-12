package Strategy.Payment;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;

public interface PaymentStrategy {
    public PaymentTransaction payOrder(CreditCard card, int amount, String contents);
}
