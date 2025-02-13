package com.ubs.g9x.databricks_etl;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SparkJob {

    @Value("${spark.master}")
    private String sparkMaster;

    public void runSparkJob() {
        SparkSession spark = SparkSession.builder()
                .appName("Hello World Spark")
                .master(sparkMaster)  // Use the configured Spark master
                .getOrCreate();
    
        try (JavaSparkContext sc = new JavaSparkContext(spark.sparkContext())) {
            List<String> data = Arrays.asList("Test", "Spark", "Job");
            JavaRDD<String> rdd = sc.parallelize(data);
            System.out.println("------------------------------------------!!!");
            rdd.foreach(word -> System.out.println("Sidhu" + word));
        } finally {
            spark.stop();
        }
    }
}