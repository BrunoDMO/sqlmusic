package bruno.music.ChallengeMusicSQL;

import bruno.music.ChallengeMusicSQL.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeMusicSqlApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeMusicSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
