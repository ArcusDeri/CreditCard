package pl.marcinm.pp5.creditcard.model;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal _limit;

    public void setLimit(BigDecimal value){
        if (value.compareTo(BigDecimal.valueOf(0)) == -1){
            throw new IllegalArgumentException("Limit cannot be lower than 0.");
        }

        _limit = value;
    }

    public BigDecimal getLimit() {
        return _limit;
    }
}
