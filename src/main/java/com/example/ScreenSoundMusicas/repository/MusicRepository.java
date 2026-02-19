package com.example.ScreenSoundMusicas.repository;

import com.example.ScreenSoundMusicas.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Musica,Long> {
}
