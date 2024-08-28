package com.prueba.docker.pruebadocker.infra;

import com.prueba.docker.pruebadocker.app.TokenUseCase;
import com.prueba.docker.pruebadocker.api.GetTokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {

    private final TokenUseCase tokenUseCase;

    public Controller(TokenUseCase tokenUseCase) {
        this.tokenUseCase = tokenUseCase;
    }

    @GetMapping("/get-token")
    public GetTokenResponse getToken() {
        log.info("In controller ... ");
        return tokenUseCase.getToken();

    }

}
