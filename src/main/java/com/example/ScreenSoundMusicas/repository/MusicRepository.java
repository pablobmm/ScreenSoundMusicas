package com.example.ScreenSoundMusicas.repository;

import com.example.ScreenSoundMusicas.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Musica,Long> {
    List<Musica> findByArtistaNomeContainingIgnoreCase(String nomeArtista);
}
