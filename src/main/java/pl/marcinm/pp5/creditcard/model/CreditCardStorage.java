package pl.marcinm.pp5.creditcard.model;

public interface CreditCardStorage {
    CreditCard load(String cardNumber);
    void add(CreditCard card);
}
