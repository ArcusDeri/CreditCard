package pl.marcinm.pp5.creditcard.model;

public class CreditCardFacade {
    private InMemoryCreditCardStorage _creditCardStorage;

    public void withdraw(WithdrawCommand withdrawCommand) {
        CreditCard card = _creditCardStorage.load(withdrawCommand.getCardNumber());
        card.withdraw(withdrawCommand.getAmount());
        _creditCardStorage.add(card);
    }

    public CardSummary getSummary(String cardNumber) {
        CreditCard card = _creditCardStorage.load(cardNumber);
        return card.getSummary();
    }
}
