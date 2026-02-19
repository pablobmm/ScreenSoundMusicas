package com.example.ScreenSoundMusicas.principal;

import com.example.ScreenSoundMusicas.model.Artista;
import com.example.ScreenSoundMusicas.model.TipoArtista;
import com.example.ScreenSoundMusicas.repository.SerieRepository;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private final SerieRepository repositorio;



    public Principal(SerieRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                1 - Cadastrar artistas
                2 - Cadastrar músicas
                3 - Listar músicas
                4 - Buscar músicas por artistas
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
        repositorio.save(artista);
        System.out.println("Artista salvo com sucesso!");
    }

    private void cadastrarMusica() {
        System.out.println("Digite o nome da música: ");
        var nomeMusica = leitura.nextLine();
    }

    private void listarMusicas(){

    }

    private void buscarMusicaPorArtista(){

    }

    private void dadosArtista(){

    }
}