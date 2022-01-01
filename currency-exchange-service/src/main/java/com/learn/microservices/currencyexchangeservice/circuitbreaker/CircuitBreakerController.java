package com.learn.microservices.currencyexchangeservice.circuitbreaker;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController {

    @GetMapping("/sample-api")
//    @Retry(name="sample-api", fallbackMethod = "test") // retry calling this endpoint and call fallback if any exception
    @CircuitBreaker(name = "sample-api",fallbackMethod = "test") //retry calling as same retry but will stop calling endpoint at some point and keep checking if the endpoint is up
//    @RateLimiter(name = "default")
    //10s -> 1000 calls to this sample api
//    @Bulkhead(name = "default")//how many concurrent calls allowed
    public String sampleApi(){
        log.info("========================Sample api call recived==============================");
//        return new RestTemplate().getForEntity("http://localhost:8080/test",String.class).getBody();
        return "Sample API";
    }

    public String test(Exception e){
        return "test";
    }

}
