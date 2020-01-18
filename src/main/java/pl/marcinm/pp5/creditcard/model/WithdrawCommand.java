package pl.marcinm.pp5.creditcard.model;

import java.math.BigDecimal;

public class WithdrawCommand {
    private final String cardNumber;
    private final BigDecimal amount;

    public WithdrawCommand(String cardNumber, BigDecimal amount) {
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
