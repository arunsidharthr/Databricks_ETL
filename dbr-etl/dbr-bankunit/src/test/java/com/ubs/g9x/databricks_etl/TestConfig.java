package com.ubs.g9x.databricks_etl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ubs.g9x.common.SparkSessionCreator;

@Configuration
public class TestConfig {

    @Bean
    public SparkSessionCreator sparkSessionCreator() {
        return new SparkSessionCreator();
    }
}