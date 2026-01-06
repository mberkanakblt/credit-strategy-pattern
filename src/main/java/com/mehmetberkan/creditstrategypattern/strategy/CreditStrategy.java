package com.mehmetberkan.creditstrategypattern.strategy;

import com.mehmetberkan.creditstrategypattern.enums.CreditType;

/**
 * Strategy Interface - Kredi faiz hesaplama stratejisi
 */
public interface CreditStrategy {
    
    double calculateInterest(double amount);
    
    CreditType getCreditType();
}
