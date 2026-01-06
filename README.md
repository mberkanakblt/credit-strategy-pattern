# Credit Calculator - Strategy Pattern

Spring Boot uygulamasında Strategy Design Pattern implementasyonu.

## Açıklama

Farklı kredi türleri (Konut, Taşıt, İhtiyaç) için faiz hesaplama servisi. Her kredi türü kendi faiz oranına sahip ve Strategy Pattern ile yönetiliyor.

## Strategy Pattern Nedir?

Behavioral (davranışsal) design pattern'lerden biridir. Benzer işlemleri yapan farklı algoritmaları ayrı sınıflara ayırıp, runtime'da hangisinin kullanılacağını belirlememizi sağlar.

**Bu projede:**
- `CreditStrategy` → Interface (ortak sözleşme)
- `HousingCreditStrategy`, `VehicleCreditStrategy`, `ConsumerCreditStrategy` → Concrete stratejiler
- `CreditService` → Context (strateji seçimini yapan sınıf)

**Neden kullandım?**
- if-else karmaşasından kurtulmak için
- Yeni kredi türü eklerken mevcut kodu değiştirmemek için (Open/Closed Principle)
- Her kredi türünün kendi sorumluluğunu taşıması için

## Kredi Türleri

| Tür | Enum | Faiz Oranı |
|-----|------|------------|
| Konut Kredisi | HOUSING | %1.5 |
| Taşıt Kredisi | VEHICLE | %2.5 |
| İhtiyaç Kredisi | CONSUMER | %3.5 |

## Proje Yapısı

```
├── config/
│   └── SecurityConfig.java
├── controller/
│   └── CreditController.java
├── enums/
│   └── CreditType.java
├── service/
│   └── CreditService.java
└── strategy/
    ├── CreditStrategy.java
    ├── HousingCreditStrategy.java
    ├── VehicleCreditStrategy.java
    └── ConsumerCreditStrategy.java
```

## API Endpoint

```http
GET /api/credit/calculate?type={TYPE}&amount={AMOUNT}
```

**Örnek:**
```bash
curl "http://localhost:9090/api/credit/calculate?type=VEHICLE&amount=100000"
```

**Response:**
```
Taşıt Kredisi - Tutar: 100000.00 TL, Faiz: 2500.00 TL, Toplam: 102500.00 TL
```

## Swagger UI

http://localhost:9090/swagger-ui.html

## Çalıştırma

```bash
./gradlew bootRun
```

## Tech Stack

- Java 21
- Spring Boot 4.0
- Spring Security
- Swagger (springdoc-openapi)
- Lombok
