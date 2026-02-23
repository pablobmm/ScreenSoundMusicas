package com.example.ScreenSoundMusicas.principal;

import com.example.ScreenSoundMusicas.model.Artista;
import com.example.ScreenSoundMusicas.model.Musica;
import com.example.ScreenSoundMusicas.model.TipoArtista;
import com.example.ScreenSoundMusicas.repository.ArtistaRepository;
import com.example.ScreenSoundMusicas.repository.MusicRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private final MusicRepository musicaRepositorio;
    private final ArtistaRepository artistaRepositorio;
    private List<Musica> musicas = new ArrayList<>();

    public Principal(MusicRepository musicaRepositorio, ArtistaRepository artistaRepositorio) {
        this.musicaRepositorio = musicaRepositorio;
        this.artistaRepositorio = artistaRepositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                1 - Cadastrar artistas
                2 - Cadastrar músicas
                3 - Listar músicas
                4 - Buscar músicas por artista
                5 - Pesquisar dados sobre um artista
                0 - Sair                                 
                """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 5:
                    dadosArtista();
                    break;
            }
        }
    }

    private void cadastrarArtista() {
        System.out.println("Digite o nome do artista: ");
        var nomeArtista = leitura.nextLine();
        System.out.println("Digite a nacionalidade do artista: ");
        var nacionalidade = leitura.nextLine();
        System.out.println("Digite o gênero do artista: ");
        var generoArtista = leitura.nextLine();
        System.out.println("Digite o tipo do artista(solo,dupla ou banda): ");
        var tipoArtista = leitura.nextLine();
        TipoArtista tipo = TipoArtista.valueOf(tipoArtista.toUpperCase());
        Artista artista = new Artista(nomeArtista,nacionalidade,generoArtista,tipo);
        artistaRepositorio.save(artista);
        System.out.println("Artista salvo com sucesso!");
    }

    private void cadastrarMusica() {
        System.out.println("Informe o nome do artista desta música: ");
        var artistaMusica = leitura.nextLine();
        Optional<Artista> artistaEncontrado = artistaRepositorio.findByNomeContainingIgnoreCase(artistaMusica);
        if (artistaEncontrado.isPresent()){
            Artista artista = artistaEncontrado.get();
            System.out.println("Artista encontrado");

            System.out.println("\nDigite o nome da música: ");
            var nomeMusica = leitura.nextLine();
            System.out.println("Digite o nome do album da música: ");
            var album = leitura.nextLine();
            System.out.println("Digite o ano de lançamento da música: ");
            var anoDigitado = leitura.nextInt();
            leitura.nextLine();

            Musica musica = new Musica(nomeMusica,album,anoDigitado,artista);
            artista.getMusicas().add(musica);
            artistaRepositorio.save(artista);
            System.out.println("Música salva com sucesso!");
        } else {
            System.out.println("Artista não encontrado!" +
                    "Cadastre primeiramente o artista");
            return;
        }
    }

    private void listarMusicas(){
        musicas = musicaRepositorio.findAll();
        musicas.stream().sorted(Comparator.comparing(Musica::getTitulo))
                .forEach(System.out::println);
    }

    private void buscarMusicaPorArtista(){
        System.out.println("Digite o nome da artista: ");
        var nomeArtista = leitura.nextLine();
        List<Musica> musica = musicaRepositorio.findByArtistaNomeContainingIgnoreCase(nomeArtista);
        musica.forEach(System.out::println);
    }

    private void dadosArtista(){

    }
}