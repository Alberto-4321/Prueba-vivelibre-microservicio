package com.prueba.docker.pruebadocker.app.impl;

import com.prueba.docker.pruebadocker.api.GetTokenResponse;
import com.prueba.docker.pruebadocker.api.ViveLibreTokenRequest;
import com.prueba.docker.pruebadocker.domain.clients.ViveLibreClient;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TokenUseCaseImplTest {
    @Mock
    private ViveLibreClient viveLibreClient;;

    @InjectMocks
    private TokenUseCaseImpl tokenUseCaseImpl;

    @Test
    @DisplayName("Deberia devolver el token y la fecha")
    void test1() {
        when(viveLibreClient.getToken(anyString(), any(ViveLibreTokenRequest.class))).thenReturn("token");
        GetTokenResponse resp = tokenUseCaseImpl.getToken();

        assertEquals("token", resp.getAuthVivelibreToken());
    }

    @Test
    @DisplayName("Deberia devolver un error si la llamada al docker de tokens falla")
    void test2() {
        when(viveLibreClient.getToken(anyString(), any(ViveLibreTokenRequest.class))).thenThrow(new RuntimeException(""));
        assertThrows(RuntimeException.class, () -> {
            tokenUseCaseImpl.getToken();
        });
    }
}
