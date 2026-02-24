package com.example.ScreenSoundMusicas.service;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosBiografia(
        @JsonAlias("strBiographyPT") String biografia,
        @JsonAlias("strBiographyEN") String biografiaIngles,
        @JsonAlias("strGenre") String genero,
        @JsonAlias("intFormedYear") String anoInicio
) {
}
