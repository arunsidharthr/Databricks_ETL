package com.ubs.g9x.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public SparkSessionCreator sparkSessionCreator() {
        return new SparkSessionCreator();
    }
}