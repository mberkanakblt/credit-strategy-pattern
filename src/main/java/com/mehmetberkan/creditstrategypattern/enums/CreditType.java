package com.mehmetberkan.creditstrategypattern.enums;

public enum CreditType {
    HOUSING("Konut Kredisi"),
    VEHICLE("Taşıt Kredisi"),
    CONSUMER("İhtiyaç Kredisi");

    private final String description;

    CreditType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

