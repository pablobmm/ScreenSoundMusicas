package com.example.ScreenSoundMusicas.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private Integer album;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getAlbum() {
        return album;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Artista getArtista() {
        return artista;
    }

}
