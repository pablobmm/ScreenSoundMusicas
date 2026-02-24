package com.example.ScreenSoundMusicas.service;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosArtista(
        @JsonAlias("artists") List<DadosBiografia> artistas
) {}

