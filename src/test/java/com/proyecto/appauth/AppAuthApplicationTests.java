package com.proyecto.appauth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppAuthApplicationTests {

    @Test
    void contextLoads() {
        AppAuthApplication myClass = new AppAuthApplication();
        Assertions.assertThat(myClass).isNotNull();
    }

}
