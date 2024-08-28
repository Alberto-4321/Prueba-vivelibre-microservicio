package com.prueba.docker.pruebadocker.app.impl;

import com.prueba.docker.pruebadocker.api.GetTokenResponse;
import com.prueba.docker.pruebadocker.api.ViveLibreTokenRequest;
import com.prueba.docker.pruebadocker.app.TokenUseCase;
import com.prueba.docker.pruebadocker.domain.clients.ViveLibreClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class TokenUseCaseImpl implements TokenUseCase {

    private final ViveLibreClient viveLibreClient;

    public TokenUseCaseImpl(ViveLibreClient viveLibreClient) {
        this.viveLibreClient = viveLibreClient;
    }

    @Value("${spring.cloud.openfeign.client.config.tokenViveLibre.url}")
    String url;

    @Override
    public GetTokenResponse getToken() {
        ViveLibreTokenRequest req = new ViveLibreTokenRequest("auth-vivelibre", "password");
        log.info(req.toString());
        String token = viveLibreClient.getToken("application/json", req);
        log.info("Response: "+token);
        return new GetTokenResponse(token, LocalDate.now());
    }

    public GetTokenResponse getTokenAlternativo() {
         RestTemplate restTemplate = new RestTemplate();
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);

         Map<String, String> requestBody = new HashMap<>();
         requestBody.put("username", "auth-vivelibre");
         requestBody.put("password", "password");
        log.info(requestBody.toString());
         HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

         ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

         if (response.getStatusCode() == HttpStatus.OK) {
             log.info("Response: "+response.getBody());
             return new GetTokenResponse(response.getBody(), LocalDate.now());
         } else {
             throw new RuntimeException("Failed to get token");
         }
    }


}
