package com.mehmetberkan.creditstrategypattern.strategy;

import com.mehmetberkan.creditstrategypattern.enums.CreditType;
import org.springframework.stereotype.Component;

/**
 * Konut Kredisi - %1.5 faiz
 */
@Component
public class HousingCreditStrategy implements CreditStrategy {

    private static final double INTEREST_RATE = 0.015; // %1.5

    @Override
    public double calculateInterest(double amount) {
        return amount * INTEREST_RATE;
    }

    @Override
    public CreditType getCreditType() {
        return CreditType.HOUSING;
    }
}
