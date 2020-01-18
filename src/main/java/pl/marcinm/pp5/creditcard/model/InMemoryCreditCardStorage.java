package pl.marcinm.pp5.creditcard.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCreditCardStorage implements CreditCardStorage {
    Map<String, CreditCard> cards = new ConcurrentHashMap<String, CreditCard>();

    public void add(CreditCard creditCard) {
        cards.put(creditCard.getNumber(), creditCard);
    }

    public CreditCard load(String cardNumber) {
        return cards.get(cardNumber);
    }
}
