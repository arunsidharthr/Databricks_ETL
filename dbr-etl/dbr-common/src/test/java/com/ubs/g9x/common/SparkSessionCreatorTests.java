package com.ubs.g9x.common;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.spark.sql.SparkSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestConfig.class)
@ActiveProfiles("test")
public class SparkSessionCreatorTests {

    @Autowired
    private SparkSessionCreator sparkSessionCreator;

    @Test
    void testCreateSparkSession() {
        SparkSession sparkSession = sparkSessionCreator.createSparkSession();
        assertNotNull(sparkSession, "SparkSession should not be null");
        sparkSession.stop();
    }
}