package com.learn.microservices.currencyconversionservice.bean;

import lombok.*;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyConversion {
    private Long id;
    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal conversionMultiple;
    private BigDecimal totalCalculatedAmount;
    private String environment;
}
