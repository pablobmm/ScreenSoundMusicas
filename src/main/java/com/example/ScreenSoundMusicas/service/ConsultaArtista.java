package com.example.ScreenSoundMusicas.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ConsultaArtista {
    private ObjectMapper mapper = new ObjectMapper();

    public String obterDadosArtista(String nomeArtista) {
        String artistaFormatado = nomeArtista.replace(" ", "_");
        String url = "https://www.theaudiodb.com/api/v1/json/2/search.php?s=" + artistaFormatado;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            return "Erro ao buscar dados do artista: " + e.getMessage();
        }
    }
    public DadosBiografia extrairDadosCompletos(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            DadosArtista dados = mapper.readValue(json, DadosArtista.class);
            if (dados.artistas() != null && !dados.artistas().isEmpty()) {
                var artista = dados.artistas().get(0);
                String genero = (artista.genero() == null || artista.genero().isBlank()) ? "Variado" : artista.genero();
                String bioFormatada = formatarTexto(artista.biografia(), 130);
                return new DadosBiografia(bioFormatada, artista.biografiaIngles(), genero, artista.anoInicio());
            }
        } catch (Exception e) {
            System.out.println("Erro ao converter: " + e.getMessage());
        }
        return null;
    }

    private String formatarTexto(String texto, int largura) {
        if (texto == null) return "Biografia não disponível.";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < texto.length()) {
            if (i + largura < texto.length()) {
                int proximoEspaco = texto.lastIndexOf(' ', i + largura);
                if (proximoEspaco <= i) proximoEspaco = i + largura;
                sb.append(texto, i, proximoEspaco).append("\n");
                i = proximoEspaco + 1;
            } else {
                sb.append(texto.substring(i));
                break;
            }
        }
        return sb.toString();
    }
}