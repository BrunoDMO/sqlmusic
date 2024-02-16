package bruno.music.ChallengeMusicSQL.repository;

import bruno.music.ChallengeMusicSQL.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
