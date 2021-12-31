package com.learn.microservices.limitsservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("limits-service")
@Configuration
@Data
public class LimitsConfiguration {
    private int minimum;
    private int maximum;
}
