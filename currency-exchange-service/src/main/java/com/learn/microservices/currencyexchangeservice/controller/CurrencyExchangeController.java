package com.learn.microservices.currencyexchangeservice.controller;

import com.learn.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.learn.microservices.currencyexchangeservice.reposetory.CurrencyExchangeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository repository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
log.info("retriveExchangeValue called with from : {} , to : {}", from,to);
        String port = environment.getProperty("local.server.port");

        CurrencyExchange currencyExchange = repository
                .findByFromAndTo(from, to)
                .orElseThrow(() -> new RuntimeException("Unable to find data from :" + from + " to : " + to));
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
