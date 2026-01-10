package UMC_9th.AhanOn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AhanOnApplication {

	public static void main(String[] args) {
		SpringApplication.run(AhanOnApplication.class, args);
	}

}
