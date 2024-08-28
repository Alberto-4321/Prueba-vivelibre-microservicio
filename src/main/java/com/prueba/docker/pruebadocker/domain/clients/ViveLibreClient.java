package com.prueba.docker.pruebadocker.domain.clients;

import com.prueba.docker.pruebadocker.api.ViveLibreTokenRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "tokenViveLibre" , url = "${spring.cloud.openfeign.client.config.tokenViveLibre.url}")
public interface ViveLibreClient {

    @PostMapping(value = "/token")
    String getToken(@RequestHeader("accept") String contentType, @RequestBody ViveLibreTokenRequest viveLibreTokenRequest);
}
