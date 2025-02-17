package com.ubs.g9x.databricks_etl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {DatabricksEtlApplication.class, TestConfig.class})
@ActiveProfiles("test")
public class DatabricksEtlApplicationTests {

    @Test
    void contextLoads() {
    }

}
