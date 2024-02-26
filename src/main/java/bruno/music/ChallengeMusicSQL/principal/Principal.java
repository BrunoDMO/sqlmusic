package bruno.music.ChallengeMusicSQL.principal;

import bruno.music.ChallengeMusicSQL.model.Artista;
import bruno.music.ChallengeMusicSQL.model.Musica;
import bruno.music.ChallengeMusicSQL.model.TipoArtista;
import bruno.music.ChallengeMusicSQL.repository.ArtistaRepository;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import java.util.List;
import java.util.Optional;
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
                    (2) - Cadastrar Musica
                    (3) - Listar Musicas Cadastradas
                    (4) - Listar Artistas Cadastrados
                    
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
        List<Artista> artistas = repository.mostrarListaArtistas();
        artistas.forEach(e -> System.out.printf("Artista: %s | Musicas: %s \n", e.getNome(), e.getMusica()));


    }
    private void ListarMusicas() {
        List<Musica> musicas = repository.mostrarListaMusicas();
        musicas.forEach(e -> System.out.printf("Musica: %s | Artista: %s \n",e, e.getArtista().getNome()));

    }
    private void cadastrarMusica() {
        System.out.println("Insira artista da musica");
        String artistaMusica = scanner.nextLine();
        try {
            Optional<Artista> artista = repository.procuraArtistaNoBanco(artistaMusica);

            if (artista.isPresent()){
                System.out.println("Insira nome da musica");
                String nomeMusica = scanner.nextLine();

                //creating the bidirectional connection on database
                Musica musica = new Musica(nomeMusica, artista.get());
                artista.get().addMusica(musica); //ALSO artista.get().getMusica().add(musica);
                repository.save(artista.get());

            }
            else {
                System.out.println("Artista não cadastrado, Deseja Cadastrar Agora? (Y/N)");
                String novoCadastro = scanner.nextLine();
                if (novoCadastro.equalsIgnoreCase("Y")){
                    cadastrarArtista();
                    System.out.println("Cadastrando Musica");
                    cadastrarMusica();
                }
            }
        }catch (IncorrectResultSizeDataAccessException e){
            System.out.println("Encontrado mais de um resultado contendo: " + artistaMusica.toUpperCase() + " tente adicionar o nome completo do artista");
        }



    }
    private void cadastrarArtista() {
        var CadastrarNovo = "S";
        while(CadastrarNovo == "S"){
            System.out.println("Insira nome do Artista");
            var nomeArtista = scanner.nextLine();
            System.out.println("Insira tipo de artista (Solo/Dupla/Banda)");
            var tipo = scanner.nextLine();
            TipoArtista tipoArtista = TipoArtista.fromString(tipo);

            Artista artista = new Artista(nomeArtista, tipoArtista);
            repository.save(artista);

            System.out.println("Deseja Cadastrar outro Artista? (S/N)");
            CadastrarNovo = scanner.nextLine();
        }
    }
}
