package pl.marcinm.pp5.creditcard;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.marcinm.pp5.creditcard.model.CreditCard;

import java.math.BigDecimal;

public class CreditCardTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void allowAssignLimit() {
        CreditCard creditCard = new CreditCard();
        creditCard.setLimit(BigDecimal.valueOf(1000));

        Assert.assertEquals(creditCard.getLimit(), BigDecimal.valueOf(1000));
    }

    @Test
    public void setLimitWithNegativeValue_ThrowsException(){
        CreditCard creditCard = new CreditCard();

        exceptionRule.expect(IllegalArgumentException.class);
        creditCard.setLimit(BigDecimal.valueOf(-1000));
    }

    @Test
    public void withdrawFromCard_IsPossible() {
        CreditCard creditCard = new CreditCard();
        creditCard.setLimit(BigDecimal.valueOf(1000));

        creditCard.withdraw(BigDecimal.valueOf(200));

        Assert.assertEquals(BigDecimal.valueOf(800), creditCard.getBalance());
    }
}
