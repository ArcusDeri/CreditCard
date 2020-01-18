package pl.marcinm.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardFacadeTest {
    private InMemoryCreditCardStorage _creditCardStorage;

    @Before
    public void setup() {
        _creditCardStorage = new InMemoryCreditCardStorage();
    }

    @Test
    public void allowWithdrawFromCards() {
        thereIsCreditCardIdentifiedWithNumber("1233-1464");

        CreditCardFacade api = thereIsCCApi();
        api.withdraw(new WithdrawCommand("1233-1464", BigDecimal.valueOf(300)));

        CardSummary summary = api.getSummary("1233-1464");
        Assert.assertNotNull(summary);
        Assert.assertEquals(summary.balance, BigDecimal.valueOf(700));
    }

    private CreditCardFacade thereIsCCApi() {
        return new CreditCardFacade();
    }

    private void thereIsCreditCardIdentifiedWithNumber(String id) {
        CreditCard creditCard = new CreditCard(id);
        creditCard.setLimit(BigDecimal.valueOf(1000));

        _creditCardStorage.add(creditCard);
    }
}
