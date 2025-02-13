package com.ubs.g9x.databricks_etl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DatabricksEtlApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DatabricksEtlApplication.class, args);
        SparkJob sparkJob = context.getBean(SparkJob.class);
        sparkJob.runSparkJob();
    }
}
