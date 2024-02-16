package bruno.music.ChallengeMusicSQL;

import bruno.music.ChallengeMusicSQL.principal.Principal;
import bruno.music.ChallengeMusicSQL.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeMusicSqlApplication implements CommandLineRunner {

	@Autowired
	public ArtistaRepository respository;
	public static void main(String[] args) {
		SpringApplication.run(ChallengeMusicSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(respository);
		principal.exibeMenu();
	}
}
