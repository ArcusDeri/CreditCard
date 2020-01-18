package pl.marcinm.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.util.UUID;

public class CreditCardTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void allowAssignLimit() {
        CreditCard creditCard = newCreditCard();
        creditCard.setLimit(BigDecimal.valueOf(1000));

        Assert.assertEquals(creditCard.getLimit(), BigDecimal.valueOf(1000));
    }

    private CreditCard newCreditCard() {
        return new CreditCard("8843-3322");
    }

    @Test
    public void setLimitWithNegativeValue_ThrowsException(){
        CreditCard creditCard = newCreditCard();

        exceptionRule.expect(IllegalArgumentException.class);
        creditCard.setLimit(BigDecimal.valueOf(-1000));
    }

    @Test
    public void withdrawFromCard_IsPossible() {
        CreditCard creditCard = newCreditCard();
        creditCard.setLimit(BigDecimal.valueOf(1000));

        creditCard.withdraw(BigDecimal.valueOf(200));

        Assert.assertEquals(BigDecimal.valueOf(800), creditCard.getBalance());
    }
}
