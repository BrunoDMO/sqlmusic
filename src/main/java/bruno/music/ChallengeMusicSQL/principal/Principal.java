package bruno.music.ChallengeMusicSQL.principal;

import bruno.music.ChallengeMusicSQL.model.Artista;
import bruno.music.ChallengeMusicSQL.model.TipoArtista;
import bruno.music.ChallengeMusicSQL.repository.ArtistaRepository;

import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);

    private ArtistaRepository repository;
    public Principal(ArtistaRepository respository) {
        this.repository = respository;
    }

    public void exibeMenu() {
        var option = -2;
        while (option != 0) {
            var menu = """
                    **************************************************
                    (1) - Cadastrar Artista
                    (2) - Cadastrar Musica(WIP)
                    (3) - Listar Musicas Cadastradas(WIP)
                    (4) - Listar Artistas Cadastrados(WIP)
                    
                    (0) - Sair                      
                    **************************************************           
                     """;

            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    ListarMusicas();
                    break;
                case 4:
                    ListarArtistas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Invalida!");
            }
        }
    }

    private void ListarArtistas() {

    }
    private void ListarMusicas() {

    }
    private void cadastrarMusica() {

    }
    private void cadastrarArtista() {
        System.out.println("Insira nome do Artista");
        var nomeArtista = scanner.nextLine();
        System.out.println("Isira tipo de artista (Solo/Dupla/Banda)");
        var tipo = scanner.nextLine();
        TipoArtista tipoArtista = TipoArtista.fromString(tipo);

        Artista artista = new Artista(nomeArtista, tipoArtista);
        repository.save(artista);
    }
}
