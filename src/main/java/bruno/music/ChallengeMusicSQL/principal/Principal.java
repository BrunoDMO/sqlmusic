package bruno.music.ChallengeMusicSQL.principal;

import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);

    public void exibeMenu() {
        var option = -2;
        while (option != 0) {
            var menu = """
                    ******************************
                    (1) - Cadastrar Artista(WIP)
                    (2) - Cadastrar Musica(WIP)
                            
                     0 - Sair                      
                    ******************************           
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
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Invalida!");
            }
        }
    }

    private void cadastrarMusica() {
    }

    private void cadastrarArtista() {

    }

}
