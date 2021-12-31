package com.learn.microservices.currencyconversionservice.controller;

import com.learn.microservices.currencyconversionservice.bean.CurrencyConversion;
import com.learn.microservices.currencyconversionservice.service.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

//    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
//    public CurrencyConversion calculateCurrencyConversion(
//            @PathVariable String from,
//            @PathVariable String to,
//            @PathVariable BigDecimal quantity
//            ){
//
//        Map<String, String> uriVariables=new HashMap<>();
//        uriVariables.put("from",from);
//        uriVariables.put("to",to);
//
//        ResponseEntity<CurrencyConversion> forEntity = new RestTemplate()
//                .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}"
//                        , CurrencyConversion.class
//                        , uriVariables
//                );
//
//        CurrencyConversion currencyConversion=forEntity.getBody();
//        currencyConversion.setQuantity(quantity);
//        currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
//
//        return  currencyConversion;
//
//    }

    //using feign
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ){
        CurrencyConversion currencyConversion=currencyExchangeProxy.retriveExchangeValue(from,to);
        currencyConversion.setQuantity(quantity);
        currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));

        return  currencyConversion;

    }
}
