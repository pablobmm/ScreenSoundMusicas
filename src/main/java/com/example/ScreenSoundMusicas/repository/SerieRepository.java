package com.example.ScreenSoundMusicas.repository;

import com.example.ScreenSoundMusicas.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Artista,Long> {
}
