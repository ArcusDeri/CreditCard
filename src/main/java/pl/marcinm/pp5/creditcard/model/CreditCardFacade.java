package pl.marcinm.pp5.creditcard.model;

import java.util.List;
import java.util.stream.Collectors;

public class CreditCardFacade {
    private CreditCardStorage _creditCardStorage;

    public CreditCardFacade(CreditCardStorage _creditCardStorage) {
        this._creditCardStorage = _creditCardStorage;
    }

    public void withdraw(WithdrawCommand withdrawCommand) {
        CreditCard card = _creditCardStorage.load(withdrawCommand.getCardNumber());
        card.withdraw(withdrawCommand.getAmount());
        _creditCardStorage.add(card);
    }

    public CardSummary getSummary(String cardNumber) {
        CreditCard card = _creditCardStorage.load(cardNumber);
        return card.getSummary();
    }

    public List<CardSummary> getCardsReport() {
        return _creditCardStorage.all()
                .stream()
                .map(CreditCard::getSummary)
                .collect(Collectors.toList());
    }
}
