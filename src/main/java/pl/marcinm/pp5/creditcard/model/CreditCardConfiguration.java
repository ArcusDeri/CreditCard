package pl.marcinm.pp5.creditcard.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class CreditCardConfiguration {

    @Bean
    CreditCardFacade creditCardFacade() {
        CreditCardStorage storage = getStorage();
        return new CreditCardFacade(storage);
    }

    @Bean
    CreditCardStorage inMemory() {
        return getStorage();
    }

    @Bean
    CreditCardStorage fileCCStorage() {
        return new FileCreditCardStorage();
    }

    private CreditCardStorage getStorage() {
        CreditCardStorage storage = new InMemoryCreditCardStorage();
        storage.add(buildRandomCard(1000));
        storage.add(buildRandomCard(2300));
        storage.add(buildRandomCard(1400));

        return storage;
    }

    private CreditCard buildRandomCard(long limit) {
        CreditCard card = new CreditCard(UUID.randomUUID().toString());
        card.setLimit(BigDecimal.valueOf(limit));

        return card;
    }
}
