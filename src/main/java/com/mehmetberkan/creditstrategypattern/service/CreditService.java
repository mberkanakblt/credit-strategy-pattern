package com.mehmetberkan.creditstrategypattern.service;

import com.mehmetberkan.creditstrategypattern.enums.CreditType;
import com.mehmetberkan.creditstrategypattern.strategy.CreditStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final List<CreditStrategy> strategies;

    public String calculate(CreditType creditType, double amount) {
        // strategies = [HousingCreditStrategy, VehicleCreditStrategy, ConsumerCreditStrategy]

        // Kullanıcı VEHICLE seçtiyse, listeden VEHICLE olanı buluyoruz
        CreditStrategy strategy = strategies.stream()
                .filter(s -> s.getCreditType() == creditType)  // sadece eşleşeni al
                .findFirst()                                    // ilkini bul
                .orElseThrow();                                // bulamazsan hata fırlat

        // Artık elimizde doğru strateji var
        // strategy.calculateInterest() çağrınca o sınıfın kendi faiz oranıyla hesaplıyor
        double interest = strategy.calculateInterest(amount);
        double total = amount + interest;

        return String.format("%s - Tutar: %.2f TL, Faiz: %.2f TL, Toplam: %.2f TL",
                creditType.getDescription(), amount, interest, total);
    }
}
