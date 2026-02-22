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
    private String album;

    @Column(nullable = false)
    private Integer anoLancamento;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    public Musica() {}

    public Musica(String titulo, String album, Integer anoLancamento, Artista artista) {
        this.titulo = titulo;
        this.album = album;
        this.anoLancamento = anoLancamento;
        this.artista = artista;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public Artista getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", album='" + album + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", artista=" + artista +
                '}';
    }
}
