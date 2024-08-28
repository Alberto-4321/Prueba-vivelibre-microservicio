package com.prueba.docker.pruebadocker.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViveLibreTokenRequest {
    String username;
    String password;
}
