package com.ubs.g9x.common;

import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SparkSessionCreator {

    @Value("${spark.master}")
    private String sparkMaster;

    public SparkSession createSparkSession() {
        return SparkSession.builder()
                .appName("Hello World Spark")
                .master(sparkMaster)  // Use the configured Spark master
                .getOrCreate();
    }
}