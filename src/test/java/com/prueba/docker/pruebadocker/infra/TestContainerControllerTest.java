package com.prueba.docker.pruebadocker.infra;

import com.prueba.docker.pruebadocker.api.GetTokenResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
        "spring.cloud.openfeign.client.config.tokenViveLibre.url=http://localhost:8080/"
})
public class TestContainerControllerTest{

    @Autowired
    Controller controllerTest;

    @Container
    public static MyGenericContainer appContainer = new MyGenericContainer("skeet15/auth-vivelibre")
            .withExposedPorts(8080, 8080)
            .addFixedExposedPorts(8080,8080);


    @Test
    @DisplayName("Comprueba que la llamada al Docker devuelve un token")
    void test1() {
        Integer firstMappedPort = appContainer.getFirstMappedPort();
        String ipAddress = appContainer.getHost();
        String address = appContainer.getHost() + ":" + appContainer.getMappedPort(8080);

        GetTokenResponse resp = controllerTest.getToken();

        assertFalse(resp.getAuthVivelibreToken().isEmpty());
    }
}
