package com.prueba.docker.pruebadocker.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class GetTokenResponse {

    @JsonProperty("auth-vivelibre-token")
    String authVivelibreToken;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM dd, yyyy", locale = "en_GB")
    LocalDate date;
}
