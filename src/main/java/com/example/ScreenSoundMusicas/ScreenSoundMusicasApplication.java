package com.example.ScreenSoundMusicas;

import com.example.ScreenSoundMusicas.principal.Principal;
import com.example.ScreenSoundMusicas.repository.ArtistaRepository;
import com.example.ScreenSoundMusicas.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenSoundMusicasApplication implements CommandLineRunner {

	@Autowired
	private MusicRepository musicaRepositorio;
	@Autowired
	private ArtistaRepository artistaRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(ScreenSoundMusicasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(musicaRepositorio,artistaRepositorio);
		principal.exibeMenu();
	}

}
