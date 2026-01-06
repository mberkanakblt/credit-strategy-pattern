package com.mehmetberkan.creditstrategypattern.controller;

import com.mehmetberkan.creditstrategypattern.enums.CreditType;
import com.mehmetberkan.creditstrategypattern.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit")
@RequiredArgsConstructor
public class CreditController {

    private final CreditService creditService;

    /**
     * Kredi hesapla
     * Örnek: GET /api/credit/calculate?type=HOUSING&amount=100000
     */
    @GetMapping("/calculate")
    public String calculate(@RequestParam CreditType type, @RequestParam double amount) {
        return creditService.calculate(type, amount);
    }
}
