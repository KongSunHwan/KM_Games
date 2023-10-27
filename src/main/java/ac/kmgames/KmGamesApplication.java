package ac.kmgames;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ac.kmgames.model.mapper")
public class KmGamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(KmGamesApplication.class, args);
	}

}
