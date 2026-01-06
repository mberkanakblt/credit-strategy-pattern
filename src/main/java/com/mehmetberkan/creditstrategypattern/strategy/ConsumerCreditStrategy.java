package com.mehmetberkan.creditstrategypattern.strategy;

import com.mehmetberkan.creditstrategypattern.enums.CreditType;
import org.springframework.stereotype.Component;

/**
 * İhtiyaç Kredisi - %3.5 faiz
 */
@Component
public class ConsumerCreditStrategy implements CreditStrategy {

    private static final double INTEREST_RATE = 0.035; // %3.5

    @Override
    public double calculateInterest(double amount) {
        return amount * INTEREST_RATE;
    }

    @Override
    public CreditType getCreditType() {
        return CreditType.CONSUMER;
    }
}
