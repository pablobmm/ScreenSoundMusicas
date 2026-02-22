package com.example.ScreenSoundMusicas.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String nome;

    @Column(nullable = false)
    private String nacionalidade;

    @Column(nullable = false)
    private String genero;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private TipoArtista tipo;


    public Artista() {}

    public Artista(String nome, String nacionalidade, String genero, TipoArtista tipo) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.genero = genero;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    @Override
    public String toString() {
        return nome;
    }
}
