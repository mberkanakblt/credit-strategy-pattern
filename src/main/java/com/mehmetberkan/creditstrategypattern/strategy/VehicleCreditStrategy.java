package com.mehmetberkan.creditstrategypattern.strategy;

import com.mehmetberkan.creditstrategypattern.enums.CreditType;
import org.springframework.stereotype.Component;

/**
 * Taşıt Kredisi - %2.5 faiz
 */
@Component
public class VehicleCreditStrategy implements CreditStrategy {

    private static final double INTEREST_RATE = 0.025; // %2.5

    @Override
    public double calculateInterest(double amount) {
        return amount * INTEREST_RATE;
    }

    @Override
    public CreditType getCreditType() {
        return CreditType.VEHICLE;
    }
}
