package pl.marcinm.pp5.creditcard.model;

import java.util.List;

public interface CreditCardStorage {
    CreditCard load(String cardNumber);
    void add(CreditCard card);

    List<CreditCard> all();
}
