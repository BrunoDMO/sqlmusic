package bruno.music.ChallengeMusicSQL.repository;

import bruno.music.ChallengeMusicSQL.model.Artista;
import bruno.music.ChallengeMusicSQL.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    @Query("SELECT a FROM Artista a")
    List<Artista> mostrarListaArtistas();

    @Query("SELECT a FROM Artista a WHERE a.nome ILIKE %:nome%")
    Optional<Artista> procuraArtistaNoBanco(String nome);

    @Query("SELECT m FROM Musica m")
    List<Musica> mostrarListaMusicas();
}
