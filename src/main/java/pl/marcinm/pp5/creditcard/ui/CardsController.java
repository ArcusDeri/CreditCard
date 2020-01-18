package pl.marcinm.pp5.creditcard.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marcinm.pp5.creditcard.model.CardSummary;
import pl.marcinm.pp5.creditcard.model.CreditCardFacade;

import java.util.Arrays;
import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CreditCardFacade _creditCardFacade;

    @GetMapping("/api/testIt")
    public List<String> httpHelloWorld() {
        return Arrays.asList("Hello", "world");
    }

    @GetMapping("/api/cards/balances")
    public List<CardSummary> listSummary() {
        return _creditCardFacade.getCardsReport();
    }
}
