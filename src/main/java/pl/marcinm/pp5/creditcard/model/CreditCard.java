package pl.marcinm.pp5.creditcard.model;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal _limit; //starting amount
    private BigDecimal _balance; //current amount

    public void setLimit(BigDecimal value){
        if (value.compareTo(BigDecimal.valueOf(0)) == -1){
            throw new IllegalArgumentException("Limit cannot be lower than 0.");
        }

        _limit = value;
        _balance = value;
    }

    public BigDecimal getLimit() {
        return _limit;
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(0)) == -1){
            throw new IllegalArgumentException("Amount to withdraw cannot be lower than 0.");
        }

        _balance = _balance.subtract(amount);
    }

    public BigDecimal getBalance() { return _balance; }
}
